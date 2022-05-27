package skku.Rarepet.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Positive;

@AllArgsConstructor
@Getter
public class CreateBoardResponseDto {
    @Positive
    private Long id;
}
