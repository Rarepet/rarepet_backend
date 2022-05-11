package skku.Rarepet.domain.expert.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import skku.Rarepet.domain.expert.dto.CreateExpertDto;
import skku.Rarepet.domain.expert.dto.ExpertResponseDto;
import skku.Rarepet.domain.expert.service.ExpertService;
import skku.Rarepet.global.enums.AnimalType;
import skku.Rarepet.global.interfaces.SessionConst;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/experts")
@RequiredArgsConstructor
public class ExpertController {

    private final ExpertService expertService;

    @PostMapping()
    public Long createExpert(
            @Valid @RequestBody CreateExpertDto createExpertDto,
            @SessionAttribute(name = SessionConst.SESSION, required = true) Long id
    ) {
        return expertService.createExpert(createExpertDto, id);
    }

    @PostMapping("/{id}")
    public Long acceptExpert(@PathVariable Long id) throws Exception {
        return expertService.acceptExpert(id);
    }

    @GetMapping()
    public List<ExpertResponseDto> findAllExpert(
            @RequestParam(value = "animalType", required = true) AnimalType animalType
    ) {
        return expertService.findAllExpert(animalType);
    }
}
