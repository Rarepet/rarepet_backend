package skku.Rarepet.domain.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chat_room")
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String roomId;

    @Column(nullable = false)
    private Long user;

    @Column(nullable = false)
    private Long expert;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat")
    private Collection<Message> messages;
}
