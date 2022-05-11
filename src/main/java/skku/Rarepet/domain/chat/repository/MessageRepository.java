package skku.Rarepet.domain.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skku.Rarepet.domain.chat.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>, MessageCustomRepository {
}
