package skku.Rarepet.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BoardListDto {
    @NotNull
    @Positive
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String nickname;

    @NotNull
    @Past
    private LocalDateTime createDate;

}
