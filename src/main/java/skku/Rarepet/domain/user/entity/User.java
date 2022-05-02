package skku.Rarepet.domain.user.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import skku.Rarepet.domain.expert.entity.Expert;

import javax.persistence.*;

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
    private String name;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column()
    @ColumnDefault("0")
    private int points;

//    @OneToOne(mappedBy = "user")
//    private Expert expert;
}
