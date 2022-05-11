package skku.Rarepet.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import skku.Rarepet.domain.user.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {

    List<User> findListByUsernameList(@Param("username") String username);
}
