package bg.softuni.mobilelele.mobilelele.repository;

import bg.softuni.mobilelele.mobilelele.model.entities.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {
}
