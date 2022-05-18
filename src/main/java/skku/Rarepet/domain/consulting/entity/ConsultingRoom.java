package skku.Rarepet.domain.consulting.entity;


import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
@Getter
@Table(name = "consulting_room")
public class ConsultingRoom {

    @Id @GeneratedValue
    @Column(name = "con_id")
    private Long id;

    private final Map<String, WebSocketSession> clients = new HashMap<>();

    @Override
    public int hashCode(){
        return Objects.hash(getId(), getClients());
    }
}
