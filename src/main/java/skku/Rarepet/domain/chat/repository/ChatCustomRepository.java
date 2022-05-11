package skku.Rarepet.domain.chat.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import skku.Rarepet.domain.chat.entity.ChatRoom;

import java.util.List;

@Repository
public interface ChatCustomRepository {

    @Query(value = "select * from chat_room join expert on chat_room.expert = expert.e_id where chat_room.user = :user", nativeQuery = true)
    List<ChatRoom> findMyAllChatRoom(@Param("user") Long user);
}
