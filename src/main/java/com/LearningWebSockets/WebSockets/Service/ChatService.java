package com.LearningWebSockets.WebSockets.Service;

import com.LearningWebSockets.WebSockets.DTO.MessageRequest;
import com.LearningWebSockets.WebSockets.Model.Message;
import com.LearningWebSockets.WebSockets.Model.Room;
import com.LearningWebSockets.WebSockets.Repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatService {
    private RoomService roomService;
    public Message sendMessage(String roomId, MessageRequest messageRequest){
        Room room = (Room) roomService.getRoom(messageRequest.roomId()).getBody();
        Message message = Message.builder()
                .content(messageRequest.content())
                .sender(messageRequest.sender())
                .timeStamp(messageRequest.timeStamp())
                .build();
        if(room != null){
            room.getMessageList().add(message);
            roomService.saveRoom(room);
        }
        return message;
    }
}
