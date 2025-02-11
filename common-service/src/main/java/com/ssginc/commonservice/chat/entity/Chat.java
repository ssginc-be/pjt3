package com.ssginc.commonservice.chat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가!
    private Long blogId;

    @Column(nullable = false, length = 250)
    private String name;

    @Column(nullable = false, length = 250)
    private String mail;

    @Column(nullable = false, length = 500)
    private String img;
    private String content;

    //이미지 ocr 분석 결과
    private String content2;

}
