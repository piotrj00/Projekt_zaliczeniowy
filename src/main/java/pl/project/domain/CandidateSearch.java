package pl.project.domain;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "candidateSearchId")
@ToString(of = {"candidateSearchId", "positions", "skills", "experienceLevel", "location"})
public class CandidateSearch {

    Integer candidateSearchId;

    String positions;

    String skills;

    String experienceLevel;

    String location;

    Candidate candidate;
}
