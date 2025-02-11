package com.ssginc.commonservice.login.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Member", uniqueConstraints = {
        @UniqueConstraint(name = "unique_member_id", columnNames = "member_id"),
        @UniqueConstraint(name = "unique_member_phone", columnNames = "member_phone")
})

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    @Column(name = "member_code")
    private Long id;


    @Column(name = "member_id", nullable = false, length = 50, unique = true)
    private String email; // 로그인 ID (이메일)

    @Column(name = "member_pw", length = 500)
    private String password; // 비밀번호 (OAuth 회원은 NULL)

    @Column(name = "member_name", nullable = false, length = 50)
    private String name; // 사용자 이름

    @Column(name = "member_phone", nullable = false, length = 50, unique = true)
    private String phone; // 휴대폰 번호

    @Column(name = "member_birth", nullable = false)
    private LocalDate birth; // 생년월일

    @Enumerated(EnumType.STRING)
    @Column(name = "member_gender", nullable = false)
    private Gender gender; // 성별

    @Enumerated(EnumType.STRING)
    @Column(name = "member_role", nullable = false)
    private Role role; // 권한

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate createdAt; // 가입일

    @Column(name = "last_modified_at", nullable = false)
    private LocalDate lastModifiedAt; // 최종 수정일

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
        lastModifiedAt = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastModifiedAt = LocalDate.now();
    }

    public enum Gender {
        MALE, FEMALE, NOT_SPECIFIED
    }

    public enum Role {
        MEMBER, MANAGER, ADMIN
    }
}
