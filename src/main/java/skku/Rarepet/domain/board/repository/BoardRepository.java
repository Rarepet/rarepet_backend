package skku.Rarepet.domain.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skku.Rarepet.domain.board.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, BoardCustomRepository {
}
