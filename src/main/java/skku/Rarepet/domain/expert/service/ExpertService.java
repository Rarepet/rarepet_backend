package skku.Rarepet.domain.expert.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import skku.Rarepet.domain.expert.dto.CreateExpertRequestDto;
import skku.Rarepet.domain.expert.dto.CreateExpertResponseDto;
import skku.Rarepet.domain.expert.dto.ExpertResponseDto;
import skku.Rarepet.domain.expert.entity.Expert;
import skku.Rarepet.domain.expert.enums.StatusType;
import skku.Rarepet.domain.expert.repository.ExpertRepository;
import skku.Rarepet.domain.user.entity.User;
import skku.Rarepet.global.enums.AnimalType;
import skku.Rarepet.global.error.enums.ErrorCode;
import skku.Rarepet.global.error.exception.CustomException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ExpertService {

    private final ExpertRepository expertRepository;

    public CreateExpertResponseDto createExpert(CreateExpertRequestDto createExpertRequestDto, Long id) {
        try {
            validateDuplicateExpert(id);
            Expert expert = Expert.builder()
                    .intro(createExpertRequestDto.getIntro())
                    .phone(createExpertRequestDto.getPhone())
                    .status(StatusType.REQUEST)
                    .name(createExpertRequestDto.getName())
                    .animalType(createExpertRequestDto.getAnimalType())
                    .certificate(createExpertRequestDto.getCertificate())
                    .user(User.builder().id(id).build())
                    .build();
            return new CreateExpertResponseDto(expertRepository.save(expert).getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public CreateExpertResponseDto acceptExpert(Long id) throws Exception {
        try {
            Expert expert = expertRepository.getById(id);
            expert.setStatus(StatusType.ACCEPT);
            expert = expertRepository.save(expert);
            if(expert.getStatus() != StatusType.ACCEPT)
                throw new Exception();
            return new CreateExpertResponseDto(expert.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<ExpertResponseDto> findAllExpert(AnimalType animalType) {
        List<Expert> expertList = expertRepository.findAllExpertByAnimalType(animalType.toString());
        List<ExpertResponseDto> expertResponseDto = expertList.stream()
                .map(expert -> new ExpertResponseDto(expert))
                .collect(Collectors.toList());

        return expertResponseDto;
    }

    public void validateDuplicateExpert(Long id) {
        Optional<Expert> expert = expertRepository.findExpertByUserId(id);

        if(expert.isPresent()) {
            throw new CustomException(ErrorCode.USER_ALREADY_EXIST);
        }
    }
}
