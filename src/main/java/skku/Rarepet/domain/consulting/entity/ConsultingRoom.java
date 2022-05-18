package skku.Rarepet.domain.consulting.entity;


import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * JPA 엔티티는 인터페이스 column을 가질 수가 없음
 * https://stackoverflow.com/questions/12627607/jpa-entity-with-a-interface-attribute-is-it-possible
 * 따라서 WebSocketSession 의 구현체가 필요 -> 실질적으로 힘듦
 *
 * 해결방안: Room 을 엔티티로 두지 않고, RoomRepository 와 관련된 기능을 일일이 구현하는 수밖에..
 */
//@Entity
@Getter
public class ConsultingRoom {

    @Id @GeneratedValue
    @Column(name = "con_id")
    private Long id;

    private final Map<Long, WebSocketSession> clients = new HashMap<>();


    @Override
    public int hashCode(){
        return Objects.hash(getId(), getClients());
    }
}
