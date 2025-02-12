package com.ssginc.commonservice.chat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@NoArgsConstructor
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @ManyToOne
    @JoinColumn(nullable = false,name = "chatRoomId")
    private ChatRoom chatRoom;

    @ManyToOne
    @JoinColumn(nullable = false,name = "memberCode")
    private ChatParticipant chatParticipant;

    @Column(nullable = false)
    private String messageText;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime messageTime;

}
