package skku.Rarepet.domain.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import skku.Rarepet.domain.board.dto.BoardListDto;
import skku.Rarepet.domain.board.dto.BoardResponseDto;
import skku.Rarepet.domain.board.dto.CreateBoardDto;
import skku.Rarepet.domain.board.entity.Board;
import skku.Rarepet.domain.board.service.BoardService;
import skku.Rarepet.global.interfaces.SessionConst;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping()
    public List<BoardListDto> findAll() {
        return boardService.findAll();
    }

    @PostMapping()
    public Long createBoard(
            @Valid @RequestBody CreateBoardDto createBoardDto,
            @SessionAttribute(name = SessionConst.SESSION) Long id
    ) {
        return boardService.createBoard(createBoardDto, id);
    }

    @GetMapping("/{id}")
    public Optional<BoardResponseDto> findOne(@PathVariable Long id) {
        return boardService.findOne(id);
    }
}
