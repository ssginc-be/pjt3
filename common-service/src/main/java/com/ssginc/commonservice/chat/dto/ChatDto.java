package com.ssginc.commonservice.chat.dto;

import groovy.transform.builder.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Value
@Getter
@Setter
@Builder
public class ChatDto {
    long messageId;
    String message;
    String loginId;

}
