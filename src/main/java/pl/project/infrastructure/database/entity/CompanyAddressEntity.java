package pl.project.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = "companyAddressId")
@ToString(of = {"companyAddressId", "country", "city", "postalCode", "address"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company_address")
public class CompanyAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_address_id")
    private Integer companyAddressId;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "address")
    private String address;

    @OneToOne(fetch = FetchType.LAZY
//            , mappedBy = "company_address"
    )
    private CompanyEntity company;
}
