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

    @Query(
            value = "select * from expert  where animal_type = :animalType and status = 'ACCEPT'",
            nativeQuery = true
    )
    List<Expert> findAllExpertByAnimalType(@Param("animalType")String animalType);

    @Query(value = "select e from Expert e join e.user where e.user.id = :id")
    Optional<Expert> findExpertByUserId(@Param("id") Long id);
}
