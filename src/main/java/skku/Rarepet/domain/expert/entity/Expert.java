package skku.Rarepet.domain.expert.entity;

import lombok.*;
import skku.Rarepet.domain.chat.entity.ChatRoom;
import skku.Rarepet.domain.expert.enums.StatusType;
import skku.Rarepet.domain.user.entity.User;
import skku.Rarepet.global.enums.AnimalType;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "expert")
public class Expert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="e_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column()
    private String intro;

    @Column(nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusType status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "animal_type")
    private AnimalType animalType;

    @Column(nullable = false)
    private String certificate;

    @OneToOne
    @JoinColumn(name = "u_id", referencedColumnName = "u_id", nullable = false, unique = true)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "expert")
    private Collection<ChatRoom> chatRoom;
}
