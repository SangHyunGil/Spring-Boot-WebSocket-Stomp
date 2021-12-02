package demo.websocket.controller;

import demo.websocket.dto.*;
import demo.websocket.model.entity.Chat;
import demo.websocket.model.service.ChatRoomService;
import demo.websocket.model.service.ChatService;
import demo.websocket.model.service.ResponseService;
import demo.websocket.response.MultipleResult;
import demo.websocket.response.SingleResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatRoomService chatRoomService;
    private final ChatService chatService;
    private final ResponseService responseService;

    @MessageMapping("/chat/{roomId}")
    @SendTo("/sub/{roomId}")
    public ChatMessageResponseDto sendChat(ChatMessageRequestDto message) {
        log.info("chat = {}, {}, {}", message.getRoomId(), message.getUsername(), message.getContent());
        return chatService.createChat(message);
    }

    @GetMapping("/room")
    public MultipleResult<ChatRoomFindResponseDto> findAllRooms() {
        return responseService.getMultipleResult(chatRoomService.findAllRooms());
    }

    @PostMapping("/room")
    public SingleResult<ChatRoomCreateResponseDto> createRoom(@RequestBody ChatRoomCreateRequestDto requestDto) {
        log.info("createRoom = {}, {}", requestDto.getRoomName(), requestDto.getPersonName());
        ChatRoomCreateResponseDto room = chatRoomService.createRoom(requestDto);
        return responseService.getSingleResult(room);
    }

    @GetMapping("/room/{roomId}")
    public MultipleResult<ChatFindResponseDto> findAllChats(@PathVariable Long roomId) {
        return responseService.getMultipleResult(chatService.findAllChats(roomId));
    }
}
