//package skku.Rarepet.domain.chat.service;
//
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//import skku.Rarepet.domain.chat.dto.ChatRoomListResponseDto;
//import skku.Rarepet.domain.chat.dto.CreateChatRoomDto;
//import skku.Rarepet.domain.chat.dto.CreateMessageDto;
//import skku.Rarepet.domain.chat.dto.MessageResponseDto;
//import skku.Rarepet.domain.chat.entity.ChatRoom;
//import skku.Rarepet.domain.chat.entity.Message;
//import skku.Rarepet.domain.chat.repository.ChatRepository;
//import skku.Rarepet.domain.chat.repository.MessageRepository;
//
//import java.util.List;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@AllArgsConstructor
//@Service
//public class ChatService {
//
//    private final ChatRepository chatRepository;
//    private final MessageRepository messageRepository;
//
//    public String createChatRoom(CreateChatRoomDto createChatRoomDto, Long id) {
//        try{
//            String roomId = UUID.randomUUID().toString();
//            ChatRoom chatRoom = ChatRoom.builder()
//                    .roomId(roomId)
//                    .user(id)
//                    .expert(createChatRoomDto.getExpert())
//                    .build();
//            return chatRepository.save(chatRoom).getRoomId();
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//
////    public List<ChatRoomListResponseDto> findAllChatRoom(Long user) {
////        List<ChatRoom> chatRoom = chatRepository.findMyAllChatRoom(user);
////
////
////        System.out.println(chatRoom);
////        return "he";
////    }
//
//    public Long createMessage(CreateMessageDto createMessageDto) {
//        try{
//            Message message = Message.builder()
//                    .content(createMessageDto.getMessage())
//                    .chat(createMessageDto.getId())
//                    .build();
//            return messageRepository.save(message).getId();
//        } catch(Exception e) {
//            throw e;
//        }
//    }
//
//    public List<MessageResponseDto> findAllMessageInChatRoom(Long id) {
//        List<Message> messageList = messageRepository.findAllMessageByChatRoom(id);
//        List<MessageResponseDto> messageResponseDto = messageList.stream()
//                .map(message -> new MessageResponseDto(message))
//                .collect(Collectors.toList());
//        return messageResponseDto;
//    }
//}
