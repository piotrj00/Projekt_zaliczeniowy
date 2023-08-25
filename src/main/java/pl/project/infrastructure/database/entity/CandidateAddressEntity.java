package pl.project.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = "candidateAddressId")
@ToString(of = {"candidateAddressId", "country", "city", "postalCode", "address"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "candidate_address")
public class CandidateAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_address_id")
    private Integer candidateAddressId;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "address")
    private String address;

    @OneToOne(fetch = FetchType.LAZY
//            , mappedBy = "candidate_address"
    )
    private CandidateEntity candidate;
}
