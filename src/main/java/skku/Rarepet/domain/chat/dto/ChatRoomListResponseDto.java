package skku.Rarepet.domain.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import skku.Rarepet.domain.chat.entity.ChatRoom;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Builder
@AllArgsConstructor
public class ChatRoomListResponseDto {

    @Positive
    @NotNull
    private String roomId;

    @NotNull
    private Long expert;

    @NotNull
    private String name;
}
