package law.tugas2.controller;

import law.tugas2.model.dto.RequestMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public RequestMessage receiveMessage(@Payload RequestMessage message){
        return message;
    }
}