package skku.Rarepet.domain.consulting.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import skku.Rarepet.domain.consulting.entity.Consulting;
import skku.Rarepet.global.base.BaseTimeEntity;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "review")
public class Review extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "r_id")
    private Long id;

    private String content;

    @Column(nullable = false)
    private int grade;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_id")
    private Consulting consulting;

}
