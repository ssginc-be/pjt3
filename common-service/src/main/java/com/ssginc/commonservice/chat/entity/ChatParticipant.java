package com.ssginc.commonservice.chat.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Builder
@Getter
@NoArgsConstructor
public class ChatParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long participantId;

    @Column(nullable = false)
    private int chatRoomId;

    @Column(nullable = false, unique = true)
    private Long memberCode;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime joinedAt;
}
