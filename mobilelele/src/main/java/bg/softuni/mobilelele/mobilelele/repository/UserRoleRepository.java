package bg.softuni.mobilelele.mobilelele.repository;

import bg.softuni.mobilelele.mobilelele.model.entities.UserRoleEntity;
import bg.softuni.mobilelele.mobilelele.model.entities.enums.UserRolesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Long> {
    Optional<UserRoleEntity> findByRole(UserRolesEnum role);
}
