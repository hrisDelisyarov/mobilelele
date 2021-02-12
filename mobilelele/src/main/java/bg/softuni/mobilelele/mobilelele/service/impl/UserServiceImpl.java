package bg.softuni.mobilelele.mobilelele.service.impl;

import bg.softuni.mobilelele.mobilelele.model.entities.UserEntity;
import bg.softuni.mobilelele.mobilelele.model.entities.UserRoleEntity;
import bg.softuni.mobilelele.mobilelele.model.entities.enums.UserRolesEnum;
import bg.softuni.mobilelele.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.mobilelele.security.CurrentUser;
import bg.softuni.mobilelele.mobilelele.service.UserService;
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

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
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
        List<UserRolesEnum> roles = user.getRole()
                .stream()
                .map(UserRoleEntity::getRole)
                .collect(Collectors.toList());
        currentUser.setAnonymous(false);
        currentUser.setName(user.getUsername());
        currentUser.setUserRoles(roles);

    }

    @Override
    public void logoutUser() {
        currentUser.setAnonymous(true);
    }
}
