package skku.Rarepet.domain.expert.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Positive;

@Getter
@AllArgsConstructor
public class CreateExpertResponseDto {
    @Positive
    private Long e_id;
}
