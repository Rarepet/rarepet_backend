package skku.Rarepet.domain.expert.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusType {
    REQUEST("요청"),
    ACCEPT("수락"),
    ;

    private final String status;
}
