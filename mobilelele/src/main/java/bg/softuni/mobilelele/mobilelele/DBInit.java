package bg.softuni.mobilelele.mobilelele;

import bg.softuni.mobilelele.mobilelele.model.entities.BaseEntity;
import bg.softuni.mobilelele.mobilelele.model.entities.BrandEntity;
import bg.softuni.mobilelele.mobilelele.model.entities.ModelEntity;
import bg.softuni.mobilelele.mobilelele.model.entities.OfferEntity;
import bg.softuni.mobilelele.mobilelele.model.entities.enums.ModelCategoryEnum;
import bg.softuni.mobilelele.mobilelele.model.entities.enums.OffersEngineEnum;
import bg.softuni.mobilelele.mobilelele.model.entities.enums.TransmissionTypeEnum;
import bg.softuni.mobilelele.mobilelele.repository.BrandRepository;
import bg.softuni.mobilelele.mobilelele.repository.ModelRepository;
import bg.softuni.mobilelele.mobilelele.repository.OfferRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final OfferRepository offerRepository;

    public DBInit(ModelRepository modelRepository, BrandRepository brandRepository, OfferRepository offerRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;

        this.offerRepository = offerRepository;
    }
   // @Transactional
    @Override
    public void run(String... args) throws Exception {
        BrandEntity ford = new BrandEntity();
        ford.setName("Ford");
        setTimeStamps(ford);



        BrandEntity honda = new BrandEntity();
        honda.setName("Honda");
        setTimeStamps(honda);

        brandRepository.saveAll(List.of(ford,honda));

        ModelEntity fiesta = initFiesta(ford);
        ModelEntity civic = initCivic(honda);
        createOffer("https://www.gannett-cdn.com/presto/2020/04/13/PDTN/baf39f3d-aebb-4c59-8e98-711fdfb3b5c4-fiesta_fr3-4.JPG", fiesta);
    }
        private void createOffer(String imageUrl, ModelEntity modelEntity){

            OfferEntity offer = new OfferEntity();
            offer.setEngine(OffersEngineEnum.GASOLINE);
            offer.setImageUrl(imageUrl);
           offer.setMileage(80000);
           offer.setPrice(10000);
           offer.setYear(2019);
           offer.setDescription("Discount ! 101% off!");
           offer.setTransmission(TransmissionTypeEnum.MANUAL);
           offer.setModel(modelEntity);
           setTimeStamps(offer);
            offerRepository.save(offer);

        }
    private ModelEntity initFiesta(BrandEntity brandEntity) {
        ModelEntity modelEntity=new ModelEntity();
        modelEntity.setCategory(ModelCategoryEnum.CAR);
        modelEntity.setBrand(brandEntity);
        modelEntity.setName("Fiesta");
        modelEntity.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/420px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg");
        modelEntity.setStartYear(1976);
        setTimeStamps(modelEntity);
        return  modelRepository.save(modelEntity);
    }
    private ModelEntity initCivic(BrandEntity brandEntity) {
        ModelEntity modelEntity=new ModelEntity();
        modelEntity.setCategory(ModelCategoryEnum.CAR);
        modelEntity.setBrand(brandEntity);
        modelEntity.setName("Civic");
        modelEntity.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Brazilian_Honda_Civic_touring_2017_%28cropped%29.jpg/1920px-Brazilian_Honda_Civic_touring_2017_%28cropped%29.jpg");
        modelEntity.setStartYear(1985);
        setTimeStamps(modelEntity);
        return  modelRepository.save(modelEntity);
    }

    private static void setTimeStamps(BaseEntity baseEntity)
    {
        baseEntity.setCreated(Instant.now());
        baseEntity.setModified(Instant.now());
    }
}
