package com.ssginc.commonservice.order.entity;

import com.ssginc.commonservice.member.entity.Member;
import com.ssginc.commonservice.product.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * @author Queue-ri
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    // 주문 외래키: 주문 id로 결제내역 식별 가능
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", unique = true)
    private Orders orders;

    // 회원 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Member member;

    @Column(nullable = false, length = 50)
    private String portoneUid;

    @Column(nullable = false, length = 50)
    private String merchantUid;

    @Column(nullable = false)
    private Integer paymentAmount;

    @Column(nullable = false)
    @ColumnDefault("PENDING")
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime paidAt;

    public enum PaymentStatus {
        PENDING, PAID, FAILED, REFUNDED
    };
}
