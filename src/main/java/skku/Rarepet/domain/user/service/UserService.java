package skku.Rarepet.domain.user.service;

import lombok.AllArgsConstructor;
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

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserResponseDto createUser(UserRegisterDto userRegisterDto) {
        try {
            validateDuplicateUser(userRegisterDto);
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
        Optional<User> user = userRepository.findByUsername(userLoginDto.getUsername());
        boolean isLoginInfoTrue = passwordEncoder.matches(userLoginDto.getPassword(), user.get().getPassword());
        UserResponseDto userResponseDto = UserResponseDto.builder().id(user.get().getId()).build();
        return userResponseDto;
    }

    /**
     * 중복 회원 검사
     */
    public void validateDuplicateUser(UserRegisterDto userRegisterDto){
        String userName = userRegisterDto.getUsername();
        Optional<User> findUsers = userRepository.findByUsername(userName);

        if (findUsers.isPresent()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
