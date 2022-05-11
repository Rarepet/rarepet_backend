package skku.Rarepet.domain.user.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import skku.Rarepet.domain.user.dto.UserLoginDto;
import skku.Rarepet.domain.user.dto.UserRegisterDto;
import skku.Rarepet.domain.user.dto.UserResponseDto;
import skku.Rarepet.domain.user.entity.User;
import skku.Rarepet.domain.user.repository.UserRepository;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDto createUser(UserRegisterDto userRegisterDto) {
        try {
            User user = User.builder()
                    .username(userRegisterDto.getUsername())
                    .password(passwordEncoder.encode(userRegisterDto.getPassword()))
                    .nickname(userRegisterDto.getNickname())
                    .email(userRegisterDto.getEmail())
                    .build();
            UserResponseDto userResponseDto = UserResponseDto.builder().id(userRepository.save(user).getId()).build();
            return userResponseDto;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }


    public UserResponseDto loginUser(UserLoginDto userLoginDto) {
        User user = userRepository.findByUsername(userLoginDto.getUsername());
        boolean isLoginInfoTrue = passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword());
        UserResponseDto userResponseDto = UserResponseDto.builder().id(user.getId()).build();
        return userResponseDto;
    }
}
