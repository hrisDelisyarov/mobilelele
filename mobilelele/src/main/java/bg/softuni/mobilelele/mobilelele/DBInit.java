package bg.softuni.mobilelele.mobilelele;

import bg.softuni.mobilelele.mobilelele.model.entities.*;
import bg.softuni.mobilelele.mobilelele.model.entities.enums.ModelCategoryEnum;
import bg.softuni.mobilelele.mobilelele.model.entities.enums.OffersEngineEnum;
import bg.softuni.mobilelele.mobilelele.model.entities.enums.TransmissionTypeEnum;
import bg.softuni.mobilelele.mobilelele.model.entities.enums.UserRolesEnum;
import bg.softuni.mobilelele.mobilelele.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final OfferRepository offerRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public DBInit(ModelRepository modelRepository, BrandRepository brandRepository,
                  OfferRepository offerRepository, PasswordEncoder passwordEncoder,
                  UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;

        this.offerRepository = offerRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
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
        initUsers();

    }

    private void initUsers(){
        UserRoleEntity adminRole = new UserRoleEntity();
        adminRole.setRole(UserRolesEnum.ADMIN);
        UserRoleEntity userRole = new UserRoleEntity();
        userRole.setRole(UserRolesEnum.USER);

        userRoleRepository.saveAll(List.of(adminRole,userRole));

        UserEntity admin = new UserEntity();
        admin.setFirstName("Petar");
        admin.setLastName("Dimitrov");
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("parola"));
        setTimeStamps(admin);
        admin.setRoles(List.of(adminRole,userRole));
        userRepository.save(admin);
        UserEntity user = new UserEntity();
        user.setFirstName("Gosho");
        user.setLastName("Georgiev");
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("parola"));
        setTimeStamps(user);
        user.setRoles(List.of(userRole));
        userRepository.save(user);
    }


        private void createOffer(String imageUrl, ModelEntity modelEntity){

            OfferEntity offer = new OfferEntity();
            offer.setEngine(OffersEngineEnum.GASOLINE);
            offer.setImageUrl(imageUrl);
           offer.setMileage(80000);
           offer.setPrice(new BigDecimal(10000));
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
