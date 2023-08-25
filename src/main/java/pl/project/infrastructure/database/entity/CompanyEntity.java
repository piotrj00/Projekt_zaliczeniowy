package pl.project.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "companyId")
@ToString(of = {"companyId", "name", "phone", "email", "contactPerson"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "contact_person")
    private String contactPerson;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_address_id")
    private CompanyAddressEntity companyAddress;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    private Set<JobOfferEntity> jobOffer;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    private Set<JobCriteriaEntity> jobCriteria;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    private Set<CandidateSearchByCompanyEntity> candidateSearchByCompany;
}
