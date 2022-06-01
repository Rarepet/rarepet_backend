package skku.Rarepet.domain.chat.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import skku.Rarepet.domain.chat.entity.ChatRoom;
import skku.Rarepet.domain.expert.entity.Expert;
import skku.Rarepet.domain.user.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatCustomRepository {

    @Query(value = "select new ChatRoom(c.id, c.expert) from ChatRoom c where c.user = :user")
    List<ChatRoom> findMyAllChatRoom(@Param("user") User user);

    @Query(value = "select new ChatRoom(c.id) from ChatRoom c where c.user = :user and c.expert = :expert")
    Optional<ChatRoom> findChatRoom(@Param("user") User user, @Param("expert") Expert expert);
}
