package skku.Rarepet.domain.chat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import skku.Rarepet.domain.chat.dto.CreateChatRoomDto;
import skku.Rarepet.domain.chat.service.ChatService;
import skku.Rarepet.global.interfaces.SessionConst;

import javax.validation.Valid;

@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
@Log4j2
public class ChatController {

    private final ChatService chatService;

    @PostMapping()
    public String createChatRoom(
            @Valid @RequestBody CreateChatRoomDto createChatRoomDto,
            @SessionAttribute(name = SessionConst.SESSION, required = true) Long id
    ) {
        return chatService.createChatRoom(createChatRoomDto, id);
    }

    @GetMapping()
    public String findMyAllChatRoom(@SessionAttribute(name = SessionConst.SESSION, required = true) Long id){
//        chatService.findAllChatRoom(id);
        log.info("@ChatController, chat GET()");
        return "chat";
    }
}
