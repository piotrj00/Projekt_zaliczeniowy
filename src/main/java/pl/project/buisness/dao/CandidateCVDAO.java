package pl.project.buisness.dao;

import pl.project.domain.CandidateCV;

import java.util.List;
import java.util.Optional;

public interface CandidateCVDAO {

    Optional<CandidateCV> findByTechnology(String technology);

    Optional<CandidateCV> findByExperienceLevel(String experienceLevel);

    List<CandidateCV> findByAvailable(Boolean available);

    List<CandidateCV> findAll();
}

