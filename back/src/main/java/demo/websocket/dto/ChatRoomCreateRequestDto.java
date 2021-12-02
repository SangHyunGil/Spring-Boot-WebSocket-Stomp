package demo.websocket.dto;

import demo.websocket.model.entity.ChatRoom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomCreateRequestDto {
    private String roomName;
    private String personName;

}
