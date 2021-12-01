package demo.websocket;

import demo.websocket.model.Chat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ChatController {
    @MessageMapping("/test/{roomId}")
    @SendTo("/topic/{roomId}")
    public Chat sendChat(Chat chat) {
        log.info("chat = {}, {}", chat.getUsername(), chat.getContent());
        return chat;
    }
}
