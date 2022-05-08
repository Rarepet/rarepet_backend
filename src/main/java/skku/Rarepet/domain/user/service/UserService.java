package skku.Rarepet.domain.user.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import skku.Rarepet.domain.user.dto.UserLoginDto;
import skku.Rarepet.domain.user.dto.UserRegisterDto;
import skku.Rarepet.domain.user.dto.UserResponse;
import skku.Rarepet.domain.user.dto.UserResponseDto;
import skku.Rarepet.domain.user.entity.User;
import skku.Rarepet.domain.user.repository.UserRepository;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public String createUser(UserRegisterDto userRegisterDto) {
        User user = User.builder()
                .username(userRegisterDto.getUsername())
                .password(userRegisterDto.getPassword())
                .name(userRegisterDto.getName())
                .nickname(userRegisterDto.getNickname())
                .email(userRegisterDto.getEmail())
                .build();
        userRepository.save(user);
        return "hello";
    }

    public UserResponseDto loginUser(UserLoginDto userLoginDto) {
        User user = userRepository.findByUsername(userLoginDto.getUsername(), userLoginDto.getPassword());
        UserResponseDto userResponseDto = UserResponseDto.builder().id(user.getId()).build();
//        UserResponse userResponse = userRepository.findByUsername(userLoginDto.getUsername(), userLoginDto.getPassword());
//        UserResponseDto userResponseDto = UserResponseDto.builder().id(userResponse.getId()).build();
        return userResponseDto;
    }
}
