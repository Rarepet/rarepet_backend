package skku.Rarepet.domain.board.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import skku.Rarepet.domain.board.dto.CreateBoardDto;
import skku.Rarepet.domain.board.entity.Board;
import skku.Rarepet.domain.board.repository.BoardRepository;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Long createBoard(CreateBoardDto createBoardDto, Long id) {
        try {
            Board board = Board.builder()
                    .content(createBoardDto.getContent())
                    .title(createBoardDto.getTitle())
                    .user(id)
                    .build();
            return boardRepository.save(board).getId();
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Object findAll() {
        return boardRepository.findAllBoardList();
    }

    public void findOne() {

    }
}
