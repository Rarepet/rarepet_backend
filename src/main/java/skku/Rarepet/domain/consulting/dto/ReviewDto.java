package skku.Rarepet.domain.consulting.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class ReviewDto {

    private String content;

    @NotNull
    private int grade;
}
