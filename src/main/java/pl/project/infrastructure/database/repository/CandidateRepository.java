package pl.project.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.project.buisness.dao.CandidateDAO;
import pl.project.domain.Candidate;
import pl.project.domain.CandidateCV;
import pl.project.infrastructure.database.entity.CandidateCVEntity;
import pl.project.infrastructure.database.entity.CandidateEntity;
import pl.project.infrastructure.database.repository.jpa.CandidateCVJpaRepository;
import pl.project.infrastructure.database.repository.jpa.CandidateJpaRepository;
import pl.project.infrastructure.database.repository.mapper.CandidateCVEntityMapper;
import pl.project.infrastructure.database.repository.mapper.CandidateEntityMapper;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class CandidateRepository implements CandidateDAO {
    private final CandidateJpaRepository candidateJpaRepository;
    private final CandidateCVJpaRepository candidateCVJpaRepository;
    private final CandidateEntityMapper candidateEntityMapper;
    private final CandidateCVEntityMapper candidateCVEntityMapper;

    @Override
    public Optional<Candidate> findByEmail(String email) {
        return candidateJpaRepository.findByEmail(email)
                .map(candidateEntityMapper::mapFromEntity);
    }

    @Override
    public Candidate saveCandidate(Candidate candidate) {
        CandidateEntity toSave = candidateEntityMapper.mapToEntity(candidate);
        CandidateEntity saved = candidateJpaRepository.save(toSave);
        return candidateEntityMapper.mapFromEntity(saved);
    }

    @Override
    public void saveCandidateCV(Candidate candidate) {
        CandidateEntity candidateToSave = candidateEntityMapper.mapToEntity(candidate);
        CandidateEntity candidateSaved = candidateJpaRepository.saveAndFlush(candidateToSave);

        CandidateCV candidateCV = candidate.getCandidateCV();
        CandidateCVEntity candidateCVToSave = candidateCVEntityMapper.mapToEntity(candidateCV);
        candidateCVJpaRepository.saveAndFlush(candidateCVToSave);

    }
}
