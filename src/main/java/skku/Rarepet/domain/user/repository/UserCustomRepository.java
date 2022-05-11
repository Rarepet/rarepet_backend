package skku.Rarepet.domain.user.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import skku.Rarepet.domain.user.entity.User;


@Repository
public interface UserCustomRepository {
    @Query(value = "select * from user where username = :username", nativeQuery = true)
    User findByUsername(@Param("username") String username);

}
