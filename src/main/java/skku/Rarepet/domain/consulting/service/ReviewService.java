package skku.Rarepet.domain.consulting.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import skku.Rarepet.domain.consulting.dto.ReviewDto;
import skku.Rarepet.domain.consulting.entity.Consulting;
import skku.Rarepet.domain.consulting.entity.Review;
import skku.Rarepet.domain.consulting.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public Long createReview(ReviewDto reviewDto, Long id){
        Review newReview = Review.builder()
                .content(reviewDto.getContent())
                .grade(reviewDto.getGrade())
                .consulting(Consulting.builder().id(id).build())
                .build();
        reviewRepository.save(newReview);
        return newReview.getId();
    }

    public Long modifyReview(ReviewDto reviewDto){
        Review modifiedReview = Review.builder()
                .content(reviewDto.getContent())
                .grade(reviewDto.getGrade())
                .consulting(Consulting.builder().build())
                .build();

        return modifiedReview.getId();
    }

}
