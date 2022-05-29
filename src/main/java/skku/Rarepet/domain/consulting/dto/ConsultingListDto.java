package skku.Rarepet.domain.consulting.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Builder
@AllArgsConstructor
public class ConsultingListDto {

    @NotNull
    private Long id;

    @NotNull
    private Long expert;

    @NotNull
    private String name;
}
