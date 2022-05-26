package babybeb.chattingservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    
    public enum MessageType {
        ENTER, TALK
    }
    
    //    private String id;
    private MessageType messageType;
    private String chatRoomId;
    private String sender;
    private String message;
}