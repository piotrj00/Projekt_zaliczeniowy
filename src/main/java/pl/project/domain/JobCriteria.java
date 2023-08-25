package pl.project.domain;

import lombok.*;

import java.util.Set;

@With
@Value
@Builder
@EqualsAndHashCode(of = "jobCriteriaId")
@ToString(of = {"jobCriteriaId", "skills", "experienceLevel", "location"})
public class JobCriteria {
    Integer jobCriteriaId;

    String skills;

    String experienceLevel;

    String location;

    Company company;

    Set<JobOffer> jobOffer;
}
