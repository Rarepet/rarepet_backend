package skku.Rarepet.domain.expert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skku.Rarepet.domain.expert.entity.Expert;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Long>, ExpertCustomRepository {
}
