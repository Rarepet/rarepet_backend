package skku.Rarepet.domain.consulting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;
import skku.Rarepet.domain.consulting.entity.ConsultingRoom;
import skku.Rarepet.domain.consulting.repository.ConsultingRoomRepository;

import javax.swing.text.html.parser.Parser;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultingRoomService {

    private final Parser parser;
    private final ConsultingRoomRepository consultingRoomRepository;

    // 코드 다시 읽어보기
    public Map<String, WebSocketSession> getClients(final ConsultingRoom consultingRoom){
        return Optional.ofNullable(consultingRoom)
                .map(room -> Collections.unmodifiableMap(room.getClients()))
                .orElse(Collections.emptyMap());
    }


}
