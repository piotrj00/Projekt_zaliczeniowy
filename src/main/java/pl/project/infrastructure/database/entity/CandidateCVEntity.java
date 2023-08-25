package pl.project.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = "candidateCVId")
@ToString(of = {"candidateCVId", "experienceLevel", "technology", "education", "available",})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "candidate_CV")
public class CandidateCVEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_CV_id")
    private Integer candidateCVId;

    @Column(name = "experience_level")
    private String experienceLevel;

    @Column(name = "technology")
    private String technology;

    @Column(name = "education")
    private String education;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "candidate_photo")
    private byte[] candidatePhoto;

    @Column(name = "available")
    private Boolean available;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "candidate_id")
    private CandidateEntity candidate;
}
