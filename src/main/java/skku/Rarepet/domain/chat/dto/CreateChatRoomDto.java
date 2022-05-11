package skku.Rarepet.domain.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@AllArgsConstructor
public class CreateChatRoomDto {

    @NotNull
    @Positive
    private Long expert;

}
