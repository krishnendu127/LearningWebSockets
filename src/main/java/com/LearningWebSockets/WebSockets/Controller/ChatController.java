package com.LearningWebSockets.WebSockets.Controller;

import com.LearningWebSockets.WebSockets.DTO.MessageRequest;
import com.LearningWebSockets.WebSockets.Model.Message;
import com.LearningWebSockets.WebSockets.Service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private ChatService chatService;
    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Message sendMessage(@DestinationVariable String roomId, @RequestBody MessageRequest messageRequest){
         return chatService.sendMessage(roomId,messageRequest);
    }
}
