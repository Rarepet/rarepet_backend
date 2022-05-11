package skku.Rarepet.domain.expert.dto;

import lombok.Builder;
import lombok.Getter;
import skku.Rarepet.domain.expert.entity.Expert;
import skku.Rarepet.global.enums.AnimalType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
public class ExpertResponseDto {
    @NotNull
    @Positive
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String intro;

    @NotNull
    private AnimalType animalType;

    public ExpertResponseDto(Expert expert) {
        this.id = expert.getId();
        this.name = expert.getName();
        this.intro = expert.getIntro();
        this.animalType = expert.getAnimalType();
    }
}
