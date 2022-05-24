package skku.Rarepet.domain.expert.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import skku.Rarepet.domain.expert.entity.Expert;
import skku.Rarepet.domain.user.entity.User;
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

    @Query("select e from Expert e where e.name = :name")
    Optional<Expert> findByName(@Param("name") String name);
}
