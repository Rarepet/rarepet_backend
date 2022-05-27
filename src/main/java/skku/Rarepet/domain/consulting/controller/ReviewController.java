package skku.Rarepet.domain.consulting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import skku.Rarepet.domain.consulting.dto.ReviewDto;
import skku.Rarepet.domain.consulting.service.ReviewService;
import skku.Rarepet.global.interfaces.SessionConst;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    // 리뷰 작성
    @PostMapping()
    public Long createReview(@Valid @RequestBody ReviewDto reviewDto,
                                 @SessionAttribute(name = SessionConst.SESSION, required = true) Long id){
        return reviewService.createReview(reviewDto,id);
    }

    // 리뷰 수정
    @GetMapping()
    public Long modifyReview(@Valid @RequestBody ReviewDto reviewDto){
        return reviewService.modifyReview(reviewDto);
    }
}
