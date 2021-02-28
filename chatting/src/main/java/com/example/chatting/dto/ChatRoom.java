package com.example.chatting.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.util.UUID;

@Slf4j
@Data
public class ChatRoom {

    private String roomId;
    private String name;

    public static ChatRoom create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }
}
