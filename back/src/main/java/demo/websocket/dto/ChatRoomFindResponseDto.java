package demo.websocket.dto;

import demo.websocket.model.entity.ChatRoom;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ChatRoomFindResponseDto {
    private Long roomId;
    private String roomName;
    private String personName;

    public static ChatRoomFindResponseDto createDto(ChatRoom chatRoom) {
        return ChatRoomFindResponseDto.builder()
                .roomId(chatRoom.getId())
                .roomName(chatRoom.getRoomName())
                .personName(chatRoom.getPersonName())
                .build();
    }

    @Builder
    public ChatRoomFindResponseDto(Long roomId, String roomName, String personName) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.personName = personName;
    }
}
