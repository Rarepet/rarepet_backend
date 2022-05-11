package skku.Rarepet.domain.user.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import skku.Rarepet.domain.user.dto.UserLoginDto;
import skku.Rarepet.domain.user.dto.UserRegisterDto;
import skku.Rarepet.domain.user.dto.UserResponseDto;
import skku.Rarepet.domain.user.entity.User;
import skku.Rarepet.domain.user.repository.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {


    private UserRepository userRepository;
    private PasswordEncoder getPasswordEncoder;

    public UserService() {
    }

    public UserResponseDto createUser(UserRegisterDto userRegisterDto) {
        try {
            User user = User.builder()
                    .username(userRegisterDto.getUsername())
                    .password(getPasswordEncoder.encode(userRegisterDto.getPassword()))
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
        Optional<User> user = userRepository.findByUsername(userLoginDto.getUsername());
        boolean isLoginInfoTrue = getPasswordEncoder.matches(userLoginDto.getPassword(), user.get().getPassword());
        UserResponseDto userResponseDto = UserResponseDto.builder().id(user.get().getId()).build();
        return userResponseDto;
    }
}
