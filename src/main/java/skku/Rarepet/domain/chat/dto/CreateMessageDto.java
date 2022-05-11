package skku.Rarepet.domain.chat.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import skku.Rarepet.domain.chat.entity.Message;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@Builder
public class CreateMessageDto {
    @NotNull
    @Positive
    private Long id;

    @NotNull
    private String roomId; // 방번호

    @NotNull
    private String sender; // 메시지 보낸사람

    @NotNull
    private String message; // 메시지

}