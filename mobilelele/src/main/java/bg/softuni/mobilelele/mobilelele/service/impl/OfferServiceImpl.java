package bg.softuni.mobilelele.mobilelele.service.impl;

import bg.softuni.mobilelele.mobilelele.model.entities.OfferEntity;
import bg.softuni.mobilelele.mobilelele.model.service.OfferServiceModel;
import bg.softuni.mobilelele.mobilelele.model.view.OfferSummaryViewModel;
import bg.softuni.mobilelele.mobilelele.repository.ModelRepository;
import bg.softuni.mobilelele.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.mobilelele.security.CurrentUser;
import bg.softuni.mobilelele.mobilelele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final CurrentUser currentUser;
    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(CurrentUser currentUser,
                            OfferRepository offerRepository,
                            ModelRepository modelRepository,
                            UserRepository userRepository,
                            ModelMapper modelMapper){

        this.currentUser = currentUser;
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<OfferSummaryViewModel> getAllOffers() {
        List<OfferEntity> offersDb =offerRepository.findAll();
        List<OfferSummaryViewModel> result = new ArrayList<>();
        if (!offersDb.isEmpty()){
            for (OfferEntity offer : offersDb
            ) {
                OfferSummaryViewModel model = new OfferSummaryViewModel();
                modelMapper.map(offer,model);
                result.add(model);
            }

        }
        return result;
    }

    @Override
    public Long save(OfferServiceModel model) {

        OfferEntity offerEntity=newEntity(model);
        OfferEntity savedEntity=offerRepository.save(offerEntity);
        return savedEntity.getId();
    }

    @Override
    public void delete(Long id) {
        offerRepository.deleteById(id);
    }

    private OfferEntity newEntity(OfferServiceModel model){
        OfferEntity offerEntity = new OfferEntity();
        modelMapper.map(model,offerEntity);
        offerEntity.setId(null);
        offerEntity.setModel(modelRepository.findById(model.getModelId()).orElseThrow());
        offerEntity.setUser(userRepository.findByUsername(currentUser.getName()).orElseThrow());
        return offerEntity;
    }
}
