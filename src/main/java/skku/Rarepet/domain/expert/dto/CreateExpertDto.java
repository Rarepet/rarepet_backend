package skku.Rarepet.domain.expert.dto;

import lombok.Getter;
import skku.Rarepet.domain.expert.enums.StatusType;
import skku.Rarepet.global.enums.AnimalType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Getter
public class CreateExpertDto {

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
