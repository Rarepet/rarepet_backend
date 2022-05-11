package skku.Rarepet.domain.user.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import skku.Rarepet.domain.chat.entity.ChatRoom;
import skku.Rarepet.domain.chat.entity.Message;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name= "user")
    private Collection<ChatRoom> chatRoom;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    private Collection<Message> messages;
}
