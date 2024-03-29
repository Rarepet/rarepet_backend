package skku.Rarepet.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class UserLoginDto {
    @NotNull
    private String username;

    @NotNull
    private String password;
}
