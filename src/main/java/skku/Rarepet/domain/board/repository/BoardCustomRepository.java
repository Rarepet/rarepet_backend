package skku.Rarepet.domain.board.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import skku.Rarepet.domain.board.entity.Board;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardCustomRepository {

    @Query(
            value = "select board.b_id, board.title, user.nickname from board join user on board.user = user.u_id",
            nativeQuery = true
    )
    List<Object> findAllBoardList();
}
