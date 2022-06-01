package skku.Rarepet.domain.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateChatRoomDto {

    @NotNull
    @Positive
    private Long expert;

}
