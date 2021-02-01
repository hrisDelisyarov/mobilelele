package bg.softuni.mobilelele.mobilelele.service.impl;

import bg.softuni.mobilelele.mobilelele.model.entities.BrandEntity;
import bg.softuni.mobilelele.mobilelele.model.entities.ModelEntity;
import bg.softuni.mobilelele.mobilelele.model.view.BrandViewModel;
import bg.softuni.mobilelele.mobilelele.model.view.ModelViewModel;
import bg.softuni.mobilelele.mobilelele.repository.ModelRepository;
import bg.softuni.mobilelele.mobilelele.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
//TODO: For the love of all holy I need to make this readable, k thx future me

    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
        List<BrandViewModel> brandViewModels = new ArrayList<>();   // <= Final result
        List<ModelEntity> models = modelRepository.findAll(); // <= All the models present in the DB
        models.forEach(modelEntity -> {
            BrandEntity brandEntity = modelEntity.getBrand();                // <= get the Model's Brand and save it as an entity
            Optional<BrandViewModel> brandViewModelOpt = findByName(brandViewModels, brandEntity.getName());     // <= Check if we
            // already have a Brand with name  {$} in our result list

            if (!brandViewModelOpt.isPresent())             // <= If the Brand is not part of the result list
            {
                BrandViewModel newBrandViewModel = new BrandViewModel();            // <= Create a new Brand from the entity
                modelMapper.map(brandEntity,newBrandViewModel);          // <= Map the entity into a BrandViewModel
                brandViewModels.add(newBrandViewModel);              // <= Add the ViewModel to our result list
                brandViewModelOpt = Optional.of(newBrandViewModel);
            }

            ModelViewModel newModelViewModel = new ModelViewModel();
            modelMapper.map(modelEntity,newModelViewModel);
            brandViewModelOpt.get().addModel(newModelViewModel);
        });

        return brandViewModels;        // <= return the result list
    }
    private static Optional<BrandViewModel> findByName(List<BrandViewModel> allModels, String name)
    {
       return allModels.stream()
               .filter(m->m.getName().equals(name))
               .findAny();
    }
}
