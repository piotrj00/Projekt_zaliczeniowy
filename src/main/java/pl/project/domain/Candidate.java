package pl.project.domain;

import lombok.*;

import java.util.Set;

@With
@Value
@Builder
@EqualsAndHashCode(of = "candidateId")
@ToString(of = {"candidateId", "name", "surname", "email", "phone"})
public class Candidate {
    Integer candidateId;

    String name;

    String surname;

    String email;

    String phone;

    CandidateAddress candidateAddress;

    CandidateCV candidateCV;

    Set<CandidateSearch> candidateSearches;
}
