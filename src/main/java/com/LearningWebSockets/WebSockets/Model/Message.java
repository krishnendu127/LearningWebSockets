package com.LearningWebSockets.WebSockets.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String sender;
    private String content;
    @Builder.Default
    private LocalDateTime timeStamp = LocalDateTime.now();
}
