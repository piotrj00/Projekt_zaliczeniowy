package pl.project.domain;

import lombok.*;

import java.util.Set;

@With
@Value
@Builder
@EqualsAndHashCode(of = "companyId")
@ToString(of = {"companyId", "name", "phone", "email", "contactPerson"})
public class Company {
    Integer companyId;

    String name;

    String phone;

    String email;

    String contactPerson;

    CompanyAddress companyAddress;

    Set<JobOffer> jobOffer;

    Set<JobCriteria> jobCriteria;

    Set<CandidateSearchByCompany> candidateSearchByCompany;
}
