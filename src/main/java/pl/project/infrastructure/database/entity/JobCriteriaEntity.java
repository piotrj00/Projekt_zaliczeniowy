package pl.project.infrastructure.database.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "jobCriteriaId")
@ToString(of = {"jobCriteriaId", "skills", "experienceLevel", "location"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_criteria")
public class JobCriteriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_criteria_id")
    private Integer jobCriteriaId;

    @Column(name = "skills")
    private String skills;

    @Column(name = "experience_level")
    private String experienceLevel;

    @Column(name = "location")
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @OneToMany(fetch = FetchType.EAGER
//            , mappedBy = "job_criteria"
    )
    private Set<JobOfferEntity> jobOffer;


}
