package skku.Rarepet.domain.consulting.dto;

import javax.validation.constraints.NotNull;

public class ConsultingDto {

    @NotNull
    private int points;

    @NotNull
    private String content;
}
