package skku.Rarepet.domain.chat.dto;

import lombok.Getter;
import skku.Rarepet.domain.chat.entity.Message;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
public class MessageResponseDto {
    @Positive
    @NotNull
    private Long m_id;

    @NotNull
    private String content;

    @NotNull
    private Long user;

    public MessageResponseDto(Message message) {
        this.m_id = message.getId();
        this.content = message.getContent();
        this.user = message.getUser();
    }
}
