package pl.project.domain;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "candidateCVId")
@ToString(of = {"candidateCVId", "experienceLevel", "technology", "education", "available"})
public class CandidateCV {
    Integer candidateCVId;

    String experienceLevel;

    String technology;

    String education;

    byte[] candidatePhoto;

    Boolean available;

    Candidate candidate;
}
