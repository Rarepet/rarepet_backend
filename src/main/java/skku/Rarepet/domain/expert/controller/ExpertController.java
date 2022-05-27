package skku.Rarepet.domain.expert.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import skku.Rarepet.domain.expert.dto.CreateExpertRequestDto;
import skku.Rarepet.domain.expert.dto.CreateExpertResponseDto;
import skku.Rarepet.domain.expert.dto.ExpertListResponseDto;
import skku.Rarepet.domain.expert.dto.ExpertResponseDto;
import skku.Rarepet.domain.expert.service.ExpertService;
import skku.Rarepet.global.enums.AnimalType;
import skku.Rarepet.global.interfaces.SessionConst;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/experts")
@RequiredArgsConstructor
public class ExpertController {

    private final ExpertService expertService;

    @PostMapping()
    public CreateExpertResponseDto createExpert(
            @Valid @RequestBody CreateExpertRequestDto createExpertRequestDto,
            @SessionAttribute(name = SessionConst.SESSION) Long id
    ) {
        return expertService.createExpert(createExpertRequestDto, id);
    }

    @PostMapping("/{id}")
    public CreateExpertResponseDto acceptExpert(@PathVariable Long id) throws Exception {
        return expertService.acceptExpert(id);
    }

    @GetMapping()
    public List<ExpertListResponseDto> findAllExpert(
            @RequestParam(value = "animalType", required = true) AnimalType animalType
    ) {
        return expertService.findAllExpert(animalType);
    }

    @GetMapping("/{id}")
    public Optional<ExpertResponseDto> findExpert(@PathVariable Long id) {
        return expertService.findExpert(id);
    }
}
