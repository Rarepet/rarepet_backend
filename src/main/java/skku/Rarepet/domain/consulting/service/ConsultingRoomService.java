package skku.Rarepet.domain.consulting.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;
import skku.Rarepet.domain.consulting.Parser;
import skku.Rarepet.domain.consulting.entity.ConsultingRoom;


import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsultingRoomService {

    private final Parser parser;

    // private final ConsultingRoomRepository consultingRoomRepository;

    // 레포지토리 대체
    private final Set<ConsultingRoom> rooms = new TreeSet<>(Comparator.comparing(ConsultingRoom::getId));


    public Set<ConsultingRoom> getRooms(){
        final TreeSet<ConsultingRoom> defensiveCopy = new TreeSet<>(Comparator.comparing(ConsultingRoom::getId));
        defensiveCopy.addAll(rooms);

        return defensiveCopy;
    }

    public Boolean addRoom(final ConsultingRoom consultingRoom){
        return rooms.add(consultingRoom);
    }

    public Optional<ConsultingRoom> findRoomByStringId(final String sid) {
        return rooms.stream().filter(r -> r.getId().equals(parser.parseId(sid).get())).findAny();
    }

    public String getRoomId(ConsultingRoom consultingRoom) {
        return consultingRoom.getId();
    }

    // 코드 다시 읽어보기
    // Entity or id
    public Map<Long, WebSocketSession> getClients(final ConsultingRoom consultingRoom){
        return Optional.ofNullable(consultingRoom)
                .map(room -> Collections.unmodifiableMap(room.getClients()))
                .orElse(Collections.emptyMap());
    }

    public WebSocketSession addClient(final ConsultingRoom consultingRoom,
                                      final Long uuid,
                                      final WebSocketSession webSocketSession){
        return consultingRoom.getClients().put(uuid, webSocketSession);
    }

    public WebSocketSession removeClient(final ConsultingRoom consultingRoom, final Long uuid) {
        return consultingRoom.getClients().remove(uuid);
    }

    /**
     * 여기서부터 room 입장, 퇴장
     */
    public String displaySelectedRoom(final String sid, final Long uuid){

        if (parser.parseId(sid).isPresent()){
            ConsultingRoom consultingRoom = findRoomByStringId(sid).orElse(null);

            if (consultingRoom != null && uuid != null){
                log.info("유저 {} 께서 방 {} 에 입장하셨습니다.", uuid, sid);

            }
            return consultingRoom.getId();
        }
        return "No room Error";
    }

    public void exitRoom(final String sid, final Long uuid){
        if (sid != null && uuid != null){
            ConsultingRoom consultingRoom = findRoomByStringId(sid).orElse(null);
            log.info("유저 {} 께서 방 {} 에 입장하셨습니다.",uuid,sid);
            this.removeClient(consultingRoom, uuid);
        }
    }
}
