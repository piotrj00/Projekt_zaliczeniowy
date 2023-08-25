package pl.project.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.infrastructure.database.entity.CandidateCVEntity;

import java.util.Optional;

@Repository
public interface CandidateCVJpaRepository extends JpaRepository<CandidateCVEntity, Integer> {
    Optional<CandidateCVEntity> findByTechnology(String technology);

    Optional<CandidateCVEntity> findByExperienceLevel(String experienceLevel);
}
