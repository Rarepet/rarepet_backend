package skku.Rarepet.domain.expert.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import skku.Rarepet.domain.expert.enums.StatusType;
import skku.Rarepet.domain.user.entity.User;
import skku.Rarepet.global.enums.AnimalType;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "expert")
public class Expert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="e_id")
    private Long id;

    @Column()
    private String intro;

    @Column(nullable = false)
    private String phone;

    @Enumerated()
    @Column(nullable = false)
    private StatusType status;

    @Enumerated()
    @Column(nullable = false, name = "animal_type")
    private AnimalType animalType;

    @Column(nullable = false)
    private String certificate;

    @OneToOne
    @JoinColumn(name = "u_id", referencedColumnName = "u_id", nullable = false)
    private User user;
}
