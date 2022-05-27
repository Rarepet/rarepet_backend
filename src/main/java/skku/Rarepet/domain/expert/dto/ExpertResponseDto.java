package skku.Rarepet.domain.expert.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import skku.Rarepet.global.enums.AnimalType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@AllArgsConstructor
public class ExpertResponseDto {
    @NotNull
    @Positive
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private AnimalType animalType;

    @NotNull
    private String intro;

    @NotNull
    private String certificate;

    @NotNull
    @PositiveOrZero
    private int points;
}
