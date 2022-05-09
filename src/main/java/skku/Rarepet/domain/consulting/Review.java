package skku.Rarepet.domain.consulting;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "review")
public class Review {

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
