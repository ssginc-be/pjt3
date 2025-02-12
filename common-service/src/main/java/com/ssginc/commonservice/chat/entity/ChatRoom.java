package com.ssginc.commonservice.chat.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@NoArgsConstructor
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chatRoomId;

    @Column(nullable = false)
    private Long storeId;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

}
