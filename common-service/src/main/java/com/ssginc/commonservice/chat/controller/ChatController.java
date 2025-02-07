package com.ssginc.commonservice.chat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ChatController {

    //채팅 화면
    @GetMapping("chat/chat")
    public String chat() {

        return "chat/chat";
    }

    //채팅
    @GetMapping("chat/chatting")
    public String chatting() {
        return "chat/chatting";
    }

    //챗봇
    @GetMapping("chat/chatbot")
    public String chatbot() {
        return "chat/chatbot";
    }


}
