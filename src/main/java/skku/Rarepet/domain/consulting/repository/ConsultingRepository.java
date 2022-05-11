package skku.Rarepet.domain.consulting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skku.Rarepet.domain.consulting.entity.Consulting;

@Repository
public interface ConsultingRepository extends JpaRepository<Consulting,Long> {
}
