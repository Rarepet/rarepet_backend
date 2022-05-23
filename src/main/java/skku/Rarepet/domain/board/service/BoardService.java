package skku.Rarepet.domain.board.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import skku.Rarepet.domain.board.dto.BoardListDto;
import skku.Rarepet.domain.board.dto.BoardResponseDto;
import skku.Rarepet.domain.board.dto.CreateBoardDto;
import skku.Rarepet.domain.board.entity.Board;
import skku.Rarepet.domain.board.repository.BoardRepository;
import skku.Rarepet.domain.user.entity.User;
import skku.Rarepet.global.error.enums.ErrorCode;
import skku.Rarepet.global.error.exception.CustomException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Long createBoard(CreateBoardDto createBoardDto, Long id) {
        try {
            User user = new User(id);
            Board board = Board.builder()
                    .content(createBoardDto.getContent())
                    .title(createBoardDto.getTitle())
                    .user(user)
                    .build();
            return boardRepository.save(board).getId();
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<BoardListDto> findAll() {
        List<Board> boardList = boardRepository.findAllBoardList();
        if(boardList.isEmpty()) {
            throw new CustomException(ErrorCode.NOT_FOUND);
        }
        List<BoardListDto> boardListDto = boardList.stream()
                .map(board -> new BoardListDto(board.getId(), board.getTitle(), board.getUser().getNickname()))
                .collect(Collectors.toList());
        return boardListDto;
    }

    public Optional<BoardResponseDto> findOne(Long id) {
        Optional<Board> board = boardRepository.findBoard(id);
        if(board.isEmpty()) {
            throw new CustomException(ErrorCode.NOT_FOUND);
        }
        Optional<BoardResponseDto> boardResponseDto = Optional.of(new BoardResponseDto(
                board.get().getId(),
                board.get().getTitle(),
                board.get().getContent(),
                board.get().getCreateDate(),
                board.get().getUser().getNickname()
        ));
        return boardResponseDto;
    }
}
