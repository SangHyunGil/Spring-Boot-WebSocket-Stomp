package demo.websocket.dto;

import demo.websocket.model.entity.ChatRoom;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatRoomCreateResponseDto {
    private Long roomId;
    private String roomName;
    private String personName;

    public static ChatRoomCreateResponseDto createDto(ChatRoom chatRoom) {
        return ChatRoomCreateResponseDto.builder()
                .roomId(chatRoom.getId())
                .roomName(chatRoom.getRoomName())
                .personName(chatRoom.getPersonName())
                .build();
    }

    @Builder
    public ChatRoomCreateResponseDto(Long roomId, String roomName, String personName) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.personName = personName;
    }
}
