package skku.Rarepet.domain.user.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import skku.Rarepet.domain.user.entity.User;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserCustomRepository {

    @Query(value = "select u from User u where username = :username")
    Optional<User> findByUsername(@Param("username") String username);

}
