package pl.project.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.project.buisness.dao.CompanyDAO;
import pl.project.domain.Company;
import pl.project.infrastructure.database.entity.CompanyEntity;
import pl.project.infrastructure.database.entity.JobCriteriaEntity;
import pl.project.infrastructure.database.entity.JobOfferEntity;
import pl.project.infrastructure.database.repository.jpa.CompanyJpaRepository;
import pl.project.infrastructure.database.repository.jpa.JobCriteriaJpaRepository;
import pl.project.infrastructure.database.repository.jpa.JobOfferJpaRepository;
import pl.project.infrastructure.database.repository.mapper.CompanyEntityMapper;
import pl.project.infrastructure.database.repository.mapper.JobCriteriaEntityMapper;
import pl.project.infrastructure.database.repository.mapper.JobOfferEntityMapper;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CompanyRepository implements CompanyDAO {
    private final CompanyJpaRepository companyJpaRepository;
    private final JobCriteriaJpaRepository jobCriteriaJpaRepository;
    private final JobOfferJpaRepository jobOfferJpaRepository;
    private final CompanyEntityMapper companyEntityMapper;
    private final JobCriteriaEntityMapper jobCriteriaEntityMapper ;
    private final JobOfferEntityMapper jobOfferEntityMapper;



    @Override
    public Optional<Company> findByName(String name) {
        return companyJpaRepository.findByName(name)
                .map(companyEntityMapper::mapFromEntity);
    }

    @Override
    public Company saveCompany(Company company) {
        CompanyEntity companyToSave = companyEntityMapper.mapToEntity(company);
        CompanyEntity saved = companyJpaRepository.save(companyToSave);
        return companyEntityMapper.mapFromEntity(saved);
    }

    @Override
    public void saveJobCriteria(Company company) {
        List<JobCriteriaEntity> jobCriteriaEntities = company.getJobCriteria().stream()
                .filter(jobCriteria -> Objects.isNull(jobCriteria.getJobCriteriaId()))
                .map(jobCriteriaEntityMapper::mapToEntity)
                .toList();

        jobCriteriaEntities
                .forEach(entity -> entity.setCompany(companyEntityMapper.mapToEntity(company)));
        jobCriteriaJpaRepository.saveAllAndFlush(jobCriteriaEntities);
    }

    @Override
    public void saveJobOffer(Company company) {
        List<JobOfferEntity> jobOfferEntities = company.getJobOffer().stream()
                .filter(jobOffer -> Objects.isNull(jobOffer.getJobOfferId()))
                .map(jobOfferEntityMapper::mapToEntity)
                .toList();

        jobOfferEntities
                .forEach(entity -> entity.setCompany(companyEntityMapper.mapToEntity(company)));
        jobOfferJpaRepository.saveAllAndFlush(jobOfferEntities);

    }
}
