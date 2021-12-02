package demo.websocket.dto;

import demo.websocket.model.entity.Chat;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatFindResponseDto {
    Long roomId;
    Long chatId;
    String username;
    String content;

    public static ChatFindResponseDto createDto(Chat chat) {
        return ChatFindResponseDto.builder()
                .roomId(chat.getId())
                .chatId(chat.getChatRoom().getId())
                .username(chat.getUsername())
                .content(chat.getContent())
                .build();
    }

    @Builder
    public ChatFindResponseDto(Long roomId, Long chatId, String username, String content) {
        this.roomId = roomId;
        this.chatId = chatId;
        this.username = username;
        this.content = content;
    }
}
