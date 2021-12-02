package demo.websocket.model.service;

import demo.websocket.Exception.ChatRoomNotFoundException;
import demo.websocket.dto.ChatFindResponseDto;
import demo.websocket.dto.ChatMessageResponseDto;
import demo.websocket.dto.ChatMessageRequestDto;
import demo.websocket.model.entity.Chat;
import demo.websocket.model.entity.ChatRoom;
import demo.websocket.model.repository.ChatRepository;
import demo.websocket.model.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final ChatRoomRepository roomRepository;

    public List<ChatFindResponseDto> findAllChats(Long roomId) {
        List<Chat> chats = chatRepository.findAllByChatRoomId(roomId).orElseThrow(ChatRoomNotFoundException::new);
        return chats.stream()
                .map(chat -> ChatFindResponseDto.createDto(chat))
                .collect(Collectors.toList());
    }

    public ChatMessageResponseDto createChat(ChatMessageRequestDto message) {
        ChatRoom chatRoom = roomRepository.findById(message.getRoomId()).orElseThrow(ChatRoomNotFoundException::new);
        Chat chat = chatRepository.save(Chat.createChat(message, chatRoom));
        return ChatMessageResponseDto.createDto(chat);
    }
}
