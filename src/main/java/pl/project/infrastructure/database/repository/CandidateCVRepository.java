package pl.project.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.project.buisness.dao.CandidateCVDAO;
import pl.project.domain.CandidateCV;
import pl.project.infrastructure.database.repository.jpa.CandidateCVJpaRepository;
import pl.project.infrastructure.database.repository.mapper.CandidateCVEntityMapper;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CandidateCVRepository implements
        CandidateCVDAO {

    private final CandidateCVJpaRepository candidateCVJpaRepository;
    private final CandidateCVEntityMapper candidateCVEntityMapper;

    @Override
    public Optional<CandidateCV> findByTechnology(String technology) {
        return candidateCVJpaRepository.findByTechnology(technology)
                .map(candidateCVEntityMapper::mapFromEntity);
    }

    @Override
    public Optional<CandidateCV> findByExperienceLevel(String experienceLevel) {
        return candidateCVJpaRepository.findByExperienceLevel(experienceLevel)
                .map(candidateCVEntityMapper::mapFromEntity);
    }

    @Override
    public List<CandidateCV> findByAvailable(Boolean available) {
        return candidateCVJpaRepository.findAll().stream()
                .map(candidateCVEntityMapper::mapFromEntity)
                .filter(CandidateCV::getAvailable)
                .toList();
    }

    @Override
    public List<CandidateCV> findAll() {
        return candidateCVJpaRepository.findAll().stream()
                .map(candidateCVEntityMapper::mapFromEntity)
                .toList();
    }
}
