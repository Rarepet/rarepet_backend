package skku.Rarepet.domain.expert.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import skku.Rarepet.domain.expert.dto.CreateExpertDto;
import skku.Rarepet.domain.expert.dto.ExpertResponseDto;
import skku.Rarepet.domain.expert.entity.Expert;
import skku.Rarepet.domain.expert.enums.StatusType;
import skku.Rarepet.domain.expert.repository.ExpertRepository;
import skku.Rarepet.domain.user.entity.User;
import skku.Rarepet.global.enums.AnimalType;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ExpertService {

    private final ExpertRepository expertRepository;

    public Long createExpert(CreateExpertDto createExpertDto, Long id) {
        try {
            Expert expert = Expert.builder()
                    .intro(createExpertDto.getIntro())
                    .phone(createExpertDto.getPhone())
                    .status(StatusType.REQUEST)
                    .name(createExpertDto.getName())
                    .animalType(createExpertDto.getAnimalType())
                    .certificate(createExpertDto.getCertificate())
                    .user(User.builder().id(id).build())
                    .build();
            return expertRepository.save(expert).getId();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Long acceptExpert(Long id) throws Exception {
        try {
            Expert expert = expertRepository.getById(id);
            expert.setStatus(StatusType.ACCEPT);
            expert = expertRepository.save(expert);
            if(expert.getStatus() != StatusType.ACCEPT)
                throw new Exception();
            return expert.getId();
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
}
