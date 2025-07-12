package web.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import web.model.ChatMessage;

@Controller
public class ChatController {

    @MessageMapping("/chat") // Client gửi đến /app/chat
    @SendTo("/topic/messages") // Server gửi đến tất cả client subscribe /topic/messages
    public ChatMessage send(ChatMessage message) {
        return message;
    }
}
