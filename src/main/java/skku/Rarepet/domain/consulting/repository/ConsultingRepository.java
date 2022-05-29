package skku.Rarepet.domain.consulting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skku.Rarepet.domain.consulting.entity.Consulting;
import skku.Rarepet.domain.user.entity.User;

import java.util.List;

@Repository
public interface ConsultingRepository extends JpaRepository<Consulting,Long>, ConsultingCustomRepository {

    List<Consulting> findListByUser(User user);
}
