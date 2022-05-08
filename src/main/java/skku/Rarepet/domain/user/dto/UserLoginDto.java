package skku.Rarepet.domain.user.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class UserLoginDto {
    @NotNull
    private String username;

    @NotNull
    private String password;
}
