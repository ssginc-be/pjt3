package com.ssginc.commonservice.member.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Queue-ri
 */

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberCode; // 조회 최적화용 PK

    @Column(nullable = false, length = 50)
    private String memberId; // 로그인용 ID

    @Column(length = 500)
    private String memberPw;

    @Column(nullable = false, length = 50)
    private String memberName;

    @Column(nullable = false)
    private LocalDate memberBirth;

    @Enumerated(EnumType.STRING)
    private MemberGender memberGender;

    @Column(nullable = false, length = 10)
    @ColumnDefault("MEMBER")
    private String memberRole;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime lastModifiedAt;

    public enum MemberGender {
        MALE, FEMALE, NOT_SPECIFIED
    };
}
