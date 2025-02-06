package com.ssginc.commonservice.chat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ChatController {

    @GetMapping("chat/chat")
    public String chat() {

        return "chat/chat";
    }
}
