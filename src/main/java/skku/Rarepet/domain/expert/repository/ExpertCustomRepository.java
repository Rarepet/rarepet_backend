package skku.Rarepet.domain.expert.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import skku.Rarepet.domain.expert.entity.Expert;
import skku.Rarepet.global.enums.AnimalType;

import java.util.List;

@Repository
public interface ExpertCustomRepository {

    @Query(
            value = "select * from expert  where animal_type = :animalType and status = 'ACCEPT'",
            nativeQuery = true
    )
    List<Expert> findAllExpertByAnimalType(@Param("animalType")String animalType);
}
