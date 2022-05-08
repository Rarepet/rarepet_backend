package skku.Rarepet.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import skku.Rarepet.domain.user.dto.UserLoginDto;
import skku.Rarepet.domain.user.dto.UserResponseDto;
import skku.Rarepet.domain.user.entity.User;
import skku.Rarepet.domain.user.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    @GetMapping()
    public String findUser() {
        return "hello";
    }

//    @PostMapping("")
//    public String createUser(@Valid @RequestBody UserRegister userRegister) {
//        userService.createUser(userRegister);
//        return "world";
//    }

    @PostMapping("/login")
    public UserResponseDto loginUser(@Valid @RequestBody UserLoginDto userLoginDto) {
        return userService.loginUser(userLoginDto);
    }
}
