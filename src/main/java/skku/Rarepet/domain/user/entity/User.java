package skku.Rarepet.domain.user.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import skku.Rarepet.domain.board.entity.Board;
import skku.Rarepet.domain.chat.entity.ChatRoom;
import skku.Rarepet.domain.chat.entity.Message;
import skku.Rarepet.global.base.BaseTimeEntity;
import skku.Rarepet.global.exception.NotEnoughPointsException;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column()
    @ColumnDefault("0")
    private int points;

    public User(Long u_id, String username, String password) {
        this.id = u_id;
        this.username = username;
        this.password = password;
    }

    public User(Long u_id) {
        this.id = u_id;
    }

    /**
     * 포인트 구매
     */
    public void addPoints(int points){
        this.points += points;
    }

    /**
     * 포인트 지출
     */
    public void payPoints(int points) {
        int restPoints = this.points - points;
        if (restPoints < 0) {
            throw new NotEnoughPointsException("포인트가 부족합니다.");
        }
        this.points = restPoints;
    }


}
