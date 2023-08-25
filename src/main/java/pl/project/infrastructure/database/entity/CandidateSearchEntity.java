package pl.project.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = "candidateSearchId")
@ToString(of = {"candidateSearchId", "skills", "experienceLevel", "location"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "candidate_search")
public class CandidateSearchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_search_id")
    private Integer candidateSearchId;

    @Column(name = "positions")
    private String positions;

    @Column(name = "skills")
    private String skills;

    @Column(name = "experience_level")
    private String experienceLevel;

    @Column(name = "location")
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id")
    private CandidateEntity candidate;
}
