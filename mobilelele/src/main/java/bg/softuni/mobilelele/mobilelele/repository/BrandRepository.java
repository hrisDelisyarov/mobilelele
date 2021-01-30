package bg.softuni.mobilelele.mobilelele.repository;

import bg.softuni.mobilelele.mobilelele.model.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {

}
