package skku.Rarepet.domain.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import skku.Rarepet.domain.board.dto.CreateBoardDto;
import skku.Rarepet.domain.board.service.BoardService;
import skku.Rarepet.global.interfaces.SessionConst;

import javax.validation.Valid;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping()
    public Object findAll(
            @SessionAttribute(name = SessionConst.SESSION) Long id
    ) {
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
    public void findOne(
            @SessionAttribute(name = SessionConst.SESSION) Long id
    ) {
        boardService.findOne();
    }
}
