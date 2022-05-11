package skku.Rarepet.domain.consulting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skku.Rarepet.domain.consulting.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
}
