package com.ssginc.commonservice.chat.service;

import com.ssginc.commonservice.chat.entity.Chat;
import com.ssginc.commonservice.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

@Value
@Service
@RequiredArgsConstructor
public class ChatServiceImpl {

    private ChatRepository chatRepository;

    public Chat saveMessage(Chat chat) {
        return chatRepository.save(chat);
    }
}
