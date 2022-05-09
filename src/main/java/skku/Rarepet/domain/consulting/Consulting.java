package skku.Rarepet.domain.consulting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import skku.Rarepet.domain.expert.entity.Expert;
import skku.Rarepet.domain.user.entity.User;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "consulting")
public class Consulting {

    @Id
    @GeneratedValue
    @Column(name = "c_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "e_id")
    private Expert expert;

    private int points;

    // 질문
    private String content;
}
