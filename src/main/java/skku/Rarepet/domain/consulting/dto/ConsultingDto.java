package skku.Rarepet.domain.consulting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class ConsultingDto {

    @NotNull
    private int points;

    @NotNull
    private String content;


}
