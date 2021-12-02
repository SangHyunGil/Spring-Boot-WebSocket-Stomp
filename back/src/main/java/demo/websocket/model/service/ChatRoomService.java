package demo.websocket.model.service;

import demo.websocket.Exception.ChatRoomNotFoundException;
import demo.websocket.dto.ChatRoomCreateRequestDto;
import demo.websocket.dto.ChatRoomCreateResponseDto;
import demo.websocket.dto.ChatRoomFindResponseDto;
import demo.websocket.model.entity.ChatRoom;
import demo.websocket.model.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomCreateResponseDto createRoom(ChatRoomCreateRequestDto requestDto) {
        ChatRoom chatRoom = chatRoomRepository.save(ChatRoom.createRoom(requestDto));
        return ChatRoomCreateResponseDto.createDto(chatRoom);
    }

    public List<ChatRoomFindResponseDto> findAllRooms() {
        List<ChatRoom> chatRooms = chatRoomRepository.findAll();
        return chatRooms.stream()
                .map(chatRoom -> ChatRoomFindResponseDto.createDto(chatRoom))
                .collect(Collectors.toList());
    }
}
