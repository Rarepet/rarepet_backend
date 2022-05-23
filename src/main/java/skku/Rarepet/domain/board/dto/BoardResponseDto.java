package skku.Rarepet.domain.board.dto;

import lombok.*;

import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BoardResponseDto {
    @Null
    @Positive
    private Long id;

    @Null
    private String title;

    @Null
    private String content;

    @Null
    @Past
    private LocalDateTime createDate;

    @Null
    private String nickname;

}
