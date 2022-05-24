package skku.Rarepet.domain.consulting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;
import skku.Rarepet.domain.consulting.Parser;
import skku.Rarepet.domain.consulting.entity.ConsultingRoom;


import java.util.*;

@Service
@RequiredArgsConstructor
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

    public Long getRoomId(ConsultingRoom consultingRoom) {
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
                                      final Long id,
                                      final WebSocketSession webSocketSession){
        return consultingRoom.getClients().put(id, webSocketSession);
    }

    public WebSocketSession removeClient(final ConsultingRoom consultingRoom, final Long id) {
        return consultingRoom.getClients().remove(id);
    }



}
