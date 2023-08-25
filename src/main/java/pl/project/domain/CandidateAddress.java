package pl.project.domain;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "candidateAddressId")
@ToString(of = {"candidateAddressId", "country", "city", "postalCode", "address"})
public class CandidateAddress {
    Integer candidateAddressId;
    String country;
    String city;
    String postalCode;
    String address;
    Candidate candidate;
}
