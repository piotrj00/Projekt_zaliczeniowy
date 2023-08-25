package pl.project.buisness;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.project.domain.Candidate;
import pl.project.domain.CandidateCV;

@Service
@AllArgsConstructor
public class CandidateCVService {

    private final CandidateService candidateService;

    public void makeCandidateCV(CandidateCV candidateCV){

        Candidate candidate = candidateService.saveCandidate(candidateCV.getCandidate());

        CandidateCV candidateCVBuilder = buildCandidateCV(candidateCV,candidate);
        candidateService.saveCandidateCV(candidateCVBuilder);

    }

    private CandidateCV buildCandidateCV(
            CandidateCV candidateCV,
            Candidate candidate
    ){
        return CandidateCV.builder()
                .experienceLevel(candidateCV.getExperienceLevel())
                .technology(candidateCV.getTechnology())
                .education(candidateCV.getEducation())
                .candidatePhoto(candidateCV.getCandidatePhoto())
                .available(candidateCV.getAvailable())
                .candidate(Candidate.builder()
                        .name(candidate.getName())
                        .surname(candidate.getSurname())
                        .email(candidate.getEmail())
                        .phone(candidate.getPhone())
                        .build())
                .build();
    }

}
