package pl.project.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = "candidateSearchByCompanyId")
@ToString(of = {"candidateSearchByCompanyId", "skills", "experienceLevel", "location"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "candidate_search_by_company")
public class CandidateSearchByCompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_search_by_company_id")
    private Integer candidateSearchByCompanyId;

    @Column(name = "skills")
    private String skills;

    @Column(name = "experience_level")
    private String experienceLevel;

    @Column(name = "education")
    private String education;

    @Column(name = "location")
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private CompanyEntity company;
}
