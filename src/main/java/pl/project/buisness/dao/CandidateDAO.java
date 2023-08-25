package pl.project.buisness.dao;

import pl.project.domain.Candidate;

import java.util.Optional;

public interface CandidateDAO {

    Optional<Candidate> findByEmail(String email);

    Candidate saveCandidate(Candidate candidate);

    void saveCandidateCV(Candidate candidate);
}
