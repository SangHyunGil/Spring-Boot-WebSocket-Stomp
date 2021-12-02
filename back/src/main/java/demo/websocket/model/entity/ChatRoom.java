package demo.websocket.model.entity;

import demo.websocket.dto.ChatRoomCreateRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomName;
    private String personName;

    @Builder
    public ChatRoom(String roomName, String personName) {
        this.roomName = roomName;
        this.personName = personName;
    }

    public static ChatRoom createRoom(ChatRoomCreateRequestDto requestDto) {
        return ChatRoom.builder()
                .roomName(requestDto.getRoomName())
                .personName(requestDto.getPersonName())
                .build();
    }
}
