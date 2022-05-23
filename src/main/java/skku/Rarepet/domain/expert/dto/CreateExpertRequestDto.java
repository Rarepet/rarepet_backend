package skku.Rarepet.domain.expert.dto;

import lombok.Getter;
import skku.Rarepet.global.enums.AnimalType;

import javax.validation.constraints.NotNull;

@Getter
public class CreateExpertRequestDto {

    @NotNull
    private String intro;

    @NotNull
//    @Pattern()
    private String phone;

    @NotNull
    private String name;

    @NotNull
    private AnimalType animalType;

    @NotNull
    private String certificate;

}
