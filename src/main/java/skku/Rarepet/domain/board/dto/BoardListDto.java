package skku.Rarepet.domain.board.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class BoardListDto {
    @NotNull
    @Positive
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String nickname;
}
