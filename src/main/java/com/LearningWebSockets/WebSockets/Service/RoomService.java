package com.LearningWebSockets.WebSockets.Service;

import com.LearningWebSockets.WebSockets.Model.Message;
import com.LearningWebSockets.WebSockets.Model.Room;
import com.LearningWebSockets.WebSockets.Repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomService {
    private RoomRepository roomRepository;

    public ResponseEntity<?> createRoom(String roomId){
        if(roomRepository.findByRoomId(roomId) != null){
            return ResponseEntity.badRequest().body("Room already exists");
        }
        Room room = Room.builder()
                .id(roomId)
                .build();
        roomRepository.save(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }
    public ResponseEntity<?> getRoom(String roomId){
        Room room = roomRepository.findByRoomId(roomId);
        if(room == null){
            return ResponseEntity.badRequest().body("Room not found");
        }
        return ResponseEntity.ok(room);
    }
    public ResponseEntity<List<Message>> getMessagesOfRoom(String roomId, Integer page, Integer size){
        Room room = roomRepository.findByRoomId(roomId);
        if(room == null) {
            return ResponseEntity.badRequest().body(new ArrayList<>());
        }
        List<Message> messageList = room.getMessageList();
        int start = Math.max(0,messageList.size()-(page+1)*size);
        int end = Math.min(messageList.size(),start+size);
        List<Message> paginatedMessageList = messageList.subList(start,end);
        return ResponseEntity.ok(paginatedMessageList);
    }
}
