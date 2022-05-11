package skku.Rarepet.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Getter
@AllArgsConstructor
public class UserRegisterDto {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @NotNull
    private String nickname;

    @NotNull
    @Email
    private String email;


}
