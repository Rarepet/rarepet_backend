package skku.Rarepet.domain.consulting.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import skku.Rarepet.domain.expert.entity.Expert;
import skku.Rarepet.domain.user.entity.User;
import skku.Rarepet.global.base.BaseTimeEntity;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "consulting")
public class Consulting extends BaseTimeEntity {

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
