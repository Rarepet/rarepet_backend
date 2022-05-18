package skku.Rarepet.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import skku.Rarepet.domain.user.dto.UserLoginDto;
import skku.Rarepet.domain.user.dto.UserRegisterDto;
import skku.Rarepet.domain.user.dto.UserResponseDto;
import skku.Rarepet.global.interfaces.SessionConst;
import skku.Rarepet.domain.user.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public String findUser() {
        return "hello";
    }

    @PostMapping()
    public UserResponseDto createUser(@Valid @RequestBody UserRegisterDto userRegisterDto) {
        return userService.createUser(userRegisterDto);
    }

    @PostMapping("/login")
    public UserResponseDto loginUser(
            @Valid @RequestBody UserLoginDto userLoginDto,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        UserResponseDto userResponseDto = userService.loginUser(userLoginDto);
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.SESSION, userResponseDto.getId());
        return userResponseDto;
    }

    @GetMapping("/test")
    public void test() {
        System.out.println("test");
    }
}
