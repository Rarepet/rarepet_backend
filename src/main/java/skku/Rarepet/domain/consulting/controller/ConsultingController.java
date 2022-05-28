package skku.Rarepet.domain.consulting.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import skku.Rarepet.domain.consulting.service.ConsultingService;
import skku.Rarepet.domain.expert.dto.ExpertListResponseDto;
import skku.Rarepet.domain.expert.service.ExpertService;
import skku.Rarepet.global.enums.AnimalType;

import java.util.List;

@RestController
@RequestMapping("/consult")
@RequiredArgsConstructor
public class ConsultingController {

    private final ConsultingService consultingService;
    private final ExpertService expertService;

    /**
     * ExpertController 기능 겹침
     */
    @GetMapping("/match")
    public List<ExpertListResponseDto> expertList(@RequestParam AnimalType animalType){
        List<ExpertListResponseDto> experts = expertService.findAllExpert(animalType);
        return experts;
    }

    @PostMapping("/connect")
    public void connectConsulting(){

    }



}
