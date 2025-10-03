package com.LearningWebSockets.WebSockets.Controller;

import com.LearningWebSockets.WebSockets.Model.Message;
import com.LearningWebSockets.WebSockets.Service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RoomController {
    private final RoomService roomService;
    @PostMapping("/createRoom")
    public ResponseEntity<?> createRoom(@RequestParam String roomId){
        return roomService.createRoom(roomId);
    }
    @GetMapping("/getRoom")
    public ResponseEntity<?> getRoom(@RequestParam String roomId){
        return roomService.getRoom(roomId);
    }
    @GetMapping("/getMessagesOfRoom")
    public ResponseEntity<List<Message>> getMessagesOfRoom(@RequestParam String roomId,@RequestParam(required = false, defaultValue = "0") Integer page,@RequestParam(defaultValue = "20", required = false) Integer size){
        return roomService.getMessagesOfRoom(roomId,page,size);
    }
}
