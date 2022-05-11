package skku.Rarepet.domain.consulting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import skku.Rarepet.domain.consulting.repository.ReviewRepository;

@Service
@AllArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public void createReview(){

    }

}
