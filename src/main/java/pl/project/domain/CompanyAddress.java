package pl.project.domain;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "companyAddressId")
@ToString(of = {"companyAddressId", "country", "city", "postalCode", "address"})
public class CompanyAddress {
    Integer companyAddressId;
    String country;
    String city;
    String postalCode;
    String address;
    Company company;
}
