package com.ssginc.commonservice.chat.controller;

import com.ssginc.commonservice.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import com.ssginc.commonservice.chat.entity.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

@Value
@Controller
@RequiredArgsConstructor
public class ChatController {

    private ChatService chatService;

    //=============================== 채팅 ===============================

    //채팅 화면
    @GetMapping("chat/chatting")
    public String chatting() {
        return "chat/chatting";
    }

    //채팅 구현
    @MessageMapping("/chatting")
    @SendTo("/topic/chatting")
    public Message sendMessage2(@RequestBody Message message) {
        System.out.println("messageVO >>> " + message);
        Date date = new Date();
        message.setTime(date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
        return message; //쓴사람 + 내용 + 시각, json형태로 감.
    }

    //챗봇
    @GetMapping("chat/chatbot")
    public String chatbot() {
        return "chat/chatbot";
    }


}
