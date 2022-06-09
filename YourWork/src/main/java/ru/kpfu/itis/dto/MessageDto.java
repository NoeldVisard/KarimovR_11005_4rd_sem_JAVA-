package ru.kpfu.itis.dto;

import lombok.Data;

@Data
public class MessageDto {
    private String messageType;
    private String username;
    private String body;
}
