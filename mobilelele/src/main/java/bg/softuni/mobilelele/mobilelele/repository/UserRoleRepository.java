package bg.softuni.mobilelele.mobilelele.repository;

import bg.softuni.mobilelele.mobilelele.model.entities.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Long> {
}
