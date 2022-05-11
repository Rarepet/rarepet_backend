package skku.Rarepet.global.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AnimalType {
    CAT("고양이"),
    DOG("강아지"),
    LIZARD("도마뱀"),
    HAMSTER("햄스터"),
    RABBIT("토끼"),
    ;

    private final String type;
}
