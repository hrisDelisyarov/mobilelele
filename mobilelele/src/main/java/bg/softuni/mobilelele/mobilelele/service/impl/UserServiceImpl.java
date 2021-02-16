package bg.softuni.mobilelele.mobilelele.service.impl;

import bg.softuni.mobilelele.mobilelele.model.entities.UserEntity;
import bg.softuni.mobilelele.mobilelele.model.entities.UserRoleEntity;
import bg.softuni.mobilelele.mobilelele.model.entities.enums.UserRolesEnum;
import bg.softuni.mobilelele.mobilelele.model.service.UserRegisterServiceModel;
import bg.softuni.mobilelele.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.mobilelele.repository.UserRoleRepository;
import bg.softuni.mobilelele.mobilelele.security.CurrentUser;
import bg.softuni.mobilelele.mobilelele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final UserRoleRepository userRoleRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository,
                           CurrentUser currentUser, ModelMapper modelMapper, UserRoleRepository userRoleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public boolean authenticate(String username, String password) {
        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(username);
        if (userEntityOptional.isEmpty())
        {
            return false;
        }
        return passwordEncoder.matches(password, userEntityOptional.get().getPassword());
    }

    @Override
    public void loginUser(String username) {
        UserEntity user = userRepository.findByUsername(username).orElseThrow();
        List<UserRolesEnum> roles = user.getRoles()
                .stream()
                .map(UserRoleEntity::getRole)
                .collect(Collectors.toList());
        currentUser.setAnonymous(false);
        currentUser.setName(user.getUsername());
        currentUser.setUserRoles(roles);

    }

    @Override
    public void registerUser(UserRegisterServiceModel model) {
        System.out.println(model.toString());
        UserEntity userEntity = newEntity(model);
            userRepository.save(userEntity);
    }

    @Override
    public void logoutUser() {
        currentUser.setAnonymous(true);
    }

    private UserEntity newEntity(UserRegisterServiceModel model){
        UserEntity userEntity = new UserEntity();
        modelMapper.map(model,userEntity);
        userEntity.setId(null);
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        Optional<UserRoleEntity> roles = getRole(UserRolesEnum.USER);
        if (roles.isPresent()) {
            userRoleEntity = roles.get();
        }
//        else{
//            userRoleRepository.save(userRoleEntity);
//        }
        userEntity.setRoles(List.of(userRoleEntity));
        userEntity.setPassword(passwordEncoder.encode(model.getPassword()));
        System.out.println(userEntity);
        return userEntity;
    }

    private Optional<UserRoleEntity> getRole(UserRolesEnum roleEnum){
        Optional<UserRoleEntity> found = userRoleRepository.findByRole(roleEnum);


        return found;
    }
}
