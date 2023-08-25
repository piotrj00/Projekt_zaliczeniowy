package pl.project.buisness;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.project.buisness.dao.CandidateDAO;
import pl.project.domain.Candidate;
import pl.project.domain.exception.NotFoundException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CandidateService {

    private final CandidateDAO candidateDAO;

    @Transactional
    public Candidate findCandidate(String email){
        Optional<Candidate> candidate = candidateDAO.findByEmail(email);
        if(candidate.isEmpty()){
            throw new NotFoundException("Could not find customer by email: [%s]".formatted(email));
        }
        return candidate.get();
    }

    @Transactional
    public Candidate saveCandidate(Candidate candidate){
        return candidateDAO.saveCandidate(candidate);
    }

    @Transactional
    public void saveCandidateCV(Candidate candidate){
        candidateDAO.saveCandidateCV(candidate);
    }
}
