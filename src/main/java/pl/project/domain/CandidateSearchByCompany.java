package pl.project.domain;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "candidateSearchByCompanyId")
@ToString(of = {"candidateSearchByCompanyId", "skills", "experienceLevel", "education", "location"})
public class CandidateSearchByCompany {
    Integer candidateSearchByCompanyId;

    String skills;

    String experienceLevel;

    String education;

    String location;

    Company company;
}
