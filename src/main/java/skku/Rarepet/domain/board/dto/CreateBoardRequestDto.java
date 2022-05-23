package skku.Rarepet.domain.board.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CreateBoardRequestDto {

    @NotNull
    private String title;

    @NotNull
    private String content;
}
