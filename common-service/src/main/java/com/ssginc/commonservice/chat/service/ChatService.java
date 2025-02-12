package com.ssginc.commonservice.chat.service;

import com.ssginc.commonservice.chat.entity.ChatRoom;
import com.ssginc.commonservice.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

@Value
@Service
@RequiredArgsConstructor
public class ChatService {

    private ChatRepository chatRepository;

    public ChatRoom saveMessage(ChatRoom chat) {
        return chatRepository.save(chat);
    }
}
