package skku.Rarepet.domain.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class ChatRoomIdDto {
    @NotNull
    private Long id;
}
