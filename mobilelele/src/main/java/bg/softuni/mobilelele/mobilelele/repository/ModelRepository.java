package bg.softuni.mobilelele.mobilelele.repository;

import bg.softuni.mobilelele.mobilelele.model.entities.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {

}
