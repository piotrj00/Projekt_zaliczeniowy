package pl.project.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.infrastructure.database.entity.JobCriteriaEntity;

import java.util.Optional;

@Repository
public interface JobCriteriaJpaRepository extends JpaRepository<JobCriteriaEntity, Integer> {
    Optional<JobCriteriaEntity> findByLocation(String location);
}
