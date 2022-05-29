package skku.Rarepet.domain.consulting.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import skku.Rarepet.domain.consulting.dto.ConsultingDto;
import skku.Rarepet.domain.consulting.dto.ConsultingListDto;
import skku.Rarepet.domain.consulting.entity.Consulting;
import skku.Rarepet.domain.consulting.repository.ConsultingRepository;
import skku.Rarepet.domain.expert.entity.Expert;
import skku.Rarepet.domain.expert.repository.ExpertRepository;
import skku.Rarepet.domain.user.entity.User;
import skku.Rarepet.domain.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class ConsultingService {

    private static final String REDIRECT = "redirect:/";

    private final ConsultingRepository consultingRepository;
    private final UserRepository userRepository;
    private final ExpertRepository expertRepository;


    public void payPoints(ConsultingDto consultingDto){
        int points = consultingDto.getPoints();
        Optional<User> user = userRepository.findByUsername(consultingDto.getUsername());
        Optional<Expert> expert = expertRepository.findByName(consultingDto.getExpertname());

        user.get().payPoints(points);
        expert.get().addPoints(points);
    }
    
    public List<Consulting> findAllConsultingList(Long id){
        Optional<User> user = userRepository.findById(id);
        return consultingRepository.findListByUser(user.get());
    }

    





}
