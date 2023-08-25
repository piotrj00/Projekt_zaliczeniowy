package pl.project.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.infrastructure.database.entity.JobOfferEntity;

import java.util.Optional;

@Repository
public interface JobOfferJpaRepository extends JpaRepository<JobOfferEntity, Integer> {
    Optional<JobOfferEntity> findByPositions(String positions);


}
