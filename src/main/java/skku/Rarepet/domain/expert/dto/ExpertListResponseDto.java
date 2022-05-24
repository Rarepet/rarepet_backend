package skku.Rarepet.domain.expert.dto;

import lombok.Getter;
import skku.Rarepet.domain.expert.entity.Expert;
import skku.Rarepet.global.enums.AnimalType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
public class ExpertListResponseDto {
    @NotNull
    @Positive
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private AnimalType animalType;

    public ExpertListResponseDto(Expert expert) {
        this.id = expert.getId();
        this.name = expert.getName();
        this.animalType = expert.getAnimalType();
    }
}
