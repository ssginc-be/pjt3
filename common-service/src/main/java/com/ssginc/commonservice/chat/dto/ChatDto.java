package com.ssginc.commonservice.chat.dto;

import groovy.transform.builder.Builder;
import lombok.Value;

@Value
@Builder
public class ChatDto {
    long messageId;
    String message;
    String loginId;

}
