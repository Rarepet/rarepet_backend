package skku.Rarepet.domain.expert.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class ConsultingExpertDto {

    @NotNull
    private String name;
}
