package com.LearningWebSockets.WebSockets.Repository;

import com.LearningWebSockets.WebSockets.Model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room,String> {
    public Room findByRoomId(String roomId);
}
