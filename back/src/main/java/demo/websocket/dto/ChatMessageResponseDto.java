package demo.websocket.dto;

import demo.websocket.model.entity.Chat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatMessageResponseDto {
    private Long roomId;
    private Long chatId;
    private String username;
    private String content;

    public static ChatMessageResponseDto createDto(Chat chat) {
        return ChatMessageResponseDto.builder()
                .roomId(chat.getChatRoom().getId())
                .chatId(chat.getId())
                .username(chat.getUsername())
                .content(chat.getContent())
                .build();
    }

    @Builder
    public ChatMessageResponseDto(Long roomId, Long chatId, String username, String content) {
        this.roomId = roomId;
        this.chatId = chatId;
        this.username = username;
        this.content = content;
    }
}
