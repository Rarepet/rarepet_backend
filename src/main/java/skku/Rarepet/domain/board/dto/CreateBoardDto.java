package skku.Rarepet.domain.board.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CreateBoardDto {

    @NotNull
    private String title;

    @NotNull
    private String content;
}
