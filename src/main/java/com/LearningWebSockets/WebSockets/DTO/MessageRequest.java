package com.LearningWebSockets.WebSockets.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Builder
public record MessageRequest(String sender, String content, LocalDateTime timeStamp, String roomId) {
}
