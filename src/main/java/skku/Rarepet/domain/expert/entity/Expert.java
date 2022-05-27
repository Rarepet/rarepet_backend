package skku.Rarepet.domain.expert.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import skku.Rarepet.domain.chat.entity.ChatRoom;
import skku.Rarepet.domain.expert.enums.StatusType;
import skku.Rarepet.domain.user.entity.User;
import skku.Rarepet.global.base.BaseTimeEntity;
import skku.Rarepet.global.enums.AnimalType;
import skku.Rarepet.global.exception.NotEnoughPointsException;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "expert")
public class Expert extends BaseTimeEntity {
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

    @ColumnDefault("0")
    private int points;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusType status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "animal_type")
    private AnimalType animalType;

    @Column(nullable = false)
    private String certificate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_id", referencedColumnName = "u_id", nullable = false, unique = true)
    private User user;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "expert")
    private Collection<ChatRoom> chatRoom;

    public Expert(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 포인트 획득
     */
    public void addPoints(int points){
        this.points += points;
    }

    /**
     * 포인트 환급
     */
    public void payPoints(int points) {
        int restPoints = this.points - points;
        if (restPoints < 0) {
            throw new NotEnoughPointsException("포인트가 부족합니다.");
        }
        this.points = restPoints;
    }


}
