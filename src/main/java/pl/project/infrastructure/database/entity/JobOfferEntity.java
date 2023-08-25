package pl.project.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@EqualsAndHashCode(of = "jobOfferId")
@ToString(of =
        {"jobOfferId", "positions", "description", "requirements", "employmentType", "salary", "dateAdd"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_offer")
public class JobOfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_offer_id")
    private Integer jobOfferId;

    @Column(name = "positions")
    private String positions;

    @Column(name = "description")
    private String description;

    @Column(name = "requirements")
    private String requirements;

    @Column(name = "employment_type")
    private String employmentType;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "date_add")
    private OffsetDateTime dateAdd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "job_criteria_id")
    private JobCriteriaEntity jobCriteria;

}
