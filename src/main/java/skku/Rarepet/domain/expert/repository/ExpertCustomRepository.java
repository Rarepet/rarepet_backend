package skku.Rarepet.domain.expert.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import skku.Rarepet.domain.expert.entity.Expert;
import skku.Rarepet.global.enums.AnimalType;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpertCustomRepository {

    @Query(value = "select new Expert(e.id, e.name) from Expert e where e.animalType = :animalType and e.status = 'ACCEPT'")
    List<Expert> findAllExpertByAnimalType(@Param("animalType")String animalType);

    @Query(value = "select e from Expert e join e.user where e.user.id = :id")
    Optional<Expert> findExpertByUserId(@Param("id") Long id);
}
