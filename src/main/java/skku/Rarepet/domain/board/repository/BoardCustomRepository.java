package skku.Rarepet.domain.board.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import skku.Rarepet.domain.board.entity.Board;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardCustomRepository {

    @Query(value = "SELECT b FROM Board b join fetch b.user")
    List<Board> findAllBoardList();

    @Query(value = "SELECT b FROM Board b join fetch b.user where b.id = :id")
    Optional<Board> findBoard(@Param("id") Long id);
}
