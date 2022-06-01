package skku.Rarepet.domain.chat.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import skku.Rarepet.domain.chat.dto.*;
import skku.Rarepet.domain.chat.entity.ChatRoom;
import skku.Rarepet.domain.chat.entity.Message;
import skku.Rarepet.domain.chat.repository.ChatRepository;
import skku.Rarepet.domain.chat.repository.MessageRepository;
import skku.Rarepet.domain.expert.entity.Expert;
import skku.Rarepet.domain.expert.repository.ExpertRepository;
import skku.Rarepet.domain.expert.service.ExpertService;
import skku.Rarepet.domain.user.entity.User;
import skku.Rarepet.global.error.enums.ErrorCode;
import skku.Rarepet.global.error.exception.CustomException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;
    private final ExpertRepository expertRepository;

    public ChatRoomIdDto createChatRoom(CreateChatRoomDto createChatRoomDto, Long u_id) {
        try{
            User user = new User(u_id);
            Expert expert = expertRepository.findById(createChatRoomDto.getExpert())
                    .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_EXIST));
            checkExistChatRoom(user, expert);
            ChatRoom chatRoom = ChatRoom.builder()
                    .user(user)
                    .expert(expert)
                    .build();
            return new ChatRoomIdDto(chatRepository.save(chatRoom).getId());
        } catch (Exception e) {
            throw e;
        }
    }

    public List<ChatRoomListResponseDto> findAllChatRoom(Long u_id) {
        User user =  new User(u_id);
        List<ChatRoom> chatRoom = chatRepository.findMyAllChatRoom(user);
        List<ChatRoomListResponseDto> chatRoomListResponseDto = chatRoom.stream()
                .map(chat -> ChatRoomListResponseDto.builder()
                        .expert(chat.getExpert().getId())
                        .name(chat.getExpert().getName())
                        .build()
                )
                .collect(Collectors.toList());
        return chatRoomListResponseDto;
    }

    public Long createMessage(CreateMessageDto createMessageDto, Long u_id) {
        try {
            ChatRoom chatRoom = chatRepository.findById(createMessageDto.getId())
                    .orElseThrow(() -> new CustomException(ErrorCode.CHATROOM_NOT_EXIST));
            User user =  new User(u_id);
            Message message = Message.builder()
                    .content(createMessageDto.getMessage())
                    .user(user)
                    .chat(chatRoom)
                    .build();
            return messageRepository.save(message).getId();
        } catch(CustomException e) {
            throw new CustomException(ErrorCode.CHATROOM_NOT_EXIST);
        } catch (Exception e) {
            throw e;
        }
    }
//
//    public List<MessageResponseDto> findAllMessageInChatRoom(Long id) {
//        List<Message> messageList = messageRepository.findAllMessageByChatRoom(id);
//        List<MessageResponseDto> messageResponseDto = messageList.stream()
//                .map(message -> new MessageResponseDto(message))
//                .collect(Collectors.toList());
//        return messageResponseDto;
//    }

    public void checkExistChatRoom(User user, Expert expert) {
        Optional<ChatRoom> chatRoom = chatRepository.findChatRoom(user, expert);
        if(chatRoom.isPresent()){
            throw new CustomException(ErrorCode.CHATROOM_ALREADY_EXIST);
        }
    }
}
