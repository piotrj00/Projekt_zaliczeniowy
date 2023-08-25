package pl.project.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.project.buisness.dao.JobOfferDAO;
import pl.project.domain.JobCriteria;
import pl.project.domain.JobOffer;
import pl.project.infrastructure.database.repository.jpa.JobCriteriaJpaRepository;
import pl.project.infrastructure.database.repository.jpa.JobOfferJpaRepository;
import pl.project.infrastructure.database.repository.mapper.JobCriteriaEntityMapper;
import pl.project.infrastructure.database.repository.mapper.JobOfferEntityMapper;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class JobOfferRepository implements JobOfferDAO {

    private final JobOfferJpaRepository jobOfferJpaRepository;
    private final JobCriteriaJpaRepository jobCriteriaJpaRepository;
    private final JobOfferEntityMapper jobOfferEntityMapper;
    private final JobCriteriaEntityMapper jobCriteriaEntityMapper;


    @Override
    public Optional<JobOffer> findByPositions(String positions) {
        return jobOfferJpaRepository.findByPositions(positions)
                .map(jobOfferEntityMapper::mapFromEntity);
    }

    @Override
    public Optional<JobCriteria> findByLocation(String location) {

        return jobCriteriaJpaRepository.findByLocation(location)
                .map(jobCriteriaEntityMapper::mapFromEntity);
    }

    @Override
    public List<JobOffer> findAll() {
        return jobOfferJpaRepository.findAll().stream()
                .map(jobOfferEntityMapper::mapFromEntity)
                .toList();

    }
}
