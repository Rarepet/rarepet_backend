package skku.Rarepet.domain.consulting.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.sockjs.transport.session.WebSocketServerSockJsSession;
import skku.Rarepet.domain.consulting.entity.Consulting;
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

    // 입장할 때 웹소켓에서 채팅방을 만들어줌
    // 방은 그냥 만들고 uuid 로
    // 방에 딱 들어가면 socket
    // 방 id 랑, websocketsession map 해서 저장을 해두는
    // websocketsession 은 저장할 필요 없음

    /**
     * DTO 로 변환할 필요 (리팩터링)
     */

    @GetMapping("/list")
    public List<Consulting> myConsultingList(@SessionAttribute(name = SessionConst.SESSION, required = false) Long id) {
         return consultingService.findAllConsultingList(id);
    }





}
