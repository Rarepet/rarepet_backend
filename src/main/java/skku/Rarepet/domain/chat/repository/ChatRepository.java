package skku.Rarepet.domain.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skku.Rarepet.domain.chat.entity.ChatRoom;

@Repository
public interface ChatRepository extends JpaRepository<ChatRoom, Long>, ChatCustomRepository {
}
