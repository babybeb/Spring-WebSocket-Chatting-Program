package babybeb.chattingservice;

import babybeb.chattingservice.ChatMessage.MessageType;
import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

@Getter
public class ChatRoom {
    
    private String roodId;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();
    
    @Builder
    public ChatRoom(String roodId, String name) {
        this.roodId = roodId;
        this.name = name;
    }
    
    public void handleActions(WebSocketSession session, ChatMessage chatMessage,
                             ChatService chatService) {
        if (chatMessage.getMessageType().equals(MessageType.ENTER)) {
            sessions.add(session);
            chatMessage.setMessage(chatMessage.getSender() + " 님이 입장했습니다.");
        }
        sendMessage(chatMessage, chatService);
    }
    
    private <T> void sendMessage(T message, ChatService chatService) {
        sessions.parallelStream()
            .forEach(session -> chatService.sendMessage(session, message));
    }
}