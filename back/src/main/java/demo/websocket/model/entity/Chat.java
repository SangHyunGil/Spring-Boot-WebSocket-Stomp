package demo.websocket.model.entity;

import demo.websocket.dto.ChatMessageRequestDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    ChatRoom chatRoom;

    public static Chat createChat(ChatMessageRequestDto message, ChatRoom chatRoom) {
        return Chat.builder()
                .username(message.getUsername())
                .content(message.getContent())
                .chatRoom(chatRoom)
                .build();
    }

    @Builder
    public Chat(String username, String content, ChatRoom chatRoom) {
        this.username = username;
        this.content = content;
        this.chatRoom = chatRoom;
    }
}
