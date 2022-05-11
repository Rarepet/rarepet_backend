package skku.Rarepet.domain.user.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import skku.Rarepet.domain.user.entity.User;

import java.util.Optional;


@Repository
public interface UserCustomRepository {
    @Query(value = "select new User(u.id, u.username, u.password) from User u where u.username = :username")
    Optional<User> findByUsername(@Param("username") String username);

}
