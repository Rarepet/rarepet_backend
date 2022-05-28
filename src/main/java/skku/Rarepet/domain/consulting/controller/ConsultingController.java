package skku.Rarepet.domain.consulting.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.sockjs.transport.session.WebSocketServerSockJsSession;
import skku.Rarepet.domain.consulting.entity.ConsultingRoom;
import skku.Rarepet.domain.consulting.service.ConsultingRoomService;
import skku.Rarepet.domain.consulting.service.ConsultingService;
import skku.Rarepet.domain.expert.dto.ExpertResponseDto;
import skku.Rarepet.domain.expert.entity.Expert;
import skku.Rarepet.domain.expert.service.ExpertService;
import skku.Rarepet.global.enums.AnimalType;
import skku.Rarepet.global.interfaces.SessionConst;

import java.util.List;

@RestController
@RequestMapping("/consult")
@RequiredArgsConstructor
public class ConsultingController {

    private final ConsultingService consultingService;
    private final ConsultingRoomService consultingRoomService;
    private final ExpertService expertService;

//    /**
//     * ExpertController 기능 겹침
//     */
//    @GetMapping("/match")
//    public List<ExpertResponseDto> expertList(@RequestParam AnimalType animalType){
//        List<ExpertResponseDto> experts = expertService.findAllExpert(animalType);
//        return experts;
//    }

    @PostMapping("/room/{sid}/user/{uuid}")
    public void enterConsultingRoom(@SessionAttribute(name = SessionConst.SESSION, required = false) Long id, WebSocketSession session) {



        ConsultingRoom consultingRoom = new ConsultingRoom();
        consultingRoomService.addRoom(consultingRoom);
        consultingRoomService.addClient(consultingRoom,id,session);
    }

    @GetMapping()
    public void exitConsultingRoom(){

    }



}
