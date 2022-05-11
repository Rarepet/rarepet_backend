package skku.Rarepet.domain.chat.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import skku.Rarepet.domain.chat.entity.Message;

import java.util.List;

@Repository
public interface MessageCustomRepository {

    @Query(value = "select * from message where m_id = :id", nativeQuery = true)
    List<Message> findAllMessageByChatRoom(@Param("id") Long id);
}
