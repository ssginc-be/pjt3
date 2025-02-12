package com.ssginc.commonservice.member.entity;

import com.ssginc.commonservice.order.entity.OrderDetail;
import com.ssginc.commonservice.order.entity.Orders;
import com.ssginc.commonservice.order.entity.Payment;
import com.ssginc.commonservice.product.entity.Product;
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
import java.util.ArrayList;
import java.util.List;

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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberGender memberGender;

    @Column(nullable = false)
    @ColumnDefault("MEMBER")
    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime lastModifiedAt;

    // (운영자 계정 한정) 회원에 연결된 팝업스토어
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    private List<MemberStore> memberStoreList;

    // 회원에 연결된 주문
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    private List<Orders> orderList = new ArrayList<>();

    // 회원에 연결된 결제내역
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    private List<Payment> paymentList = new ArrayList<>();

    public enum MemberGender {
        MALE, FEMALE, NOT_SPECIFIED
    };

    public enum MemberRole {
        MEMBER, MANAGER, ADMIN
    };
}
