package com.ssginc.commonservice.order.entity;

import com.ssginc.commonservice.member.entity.Member;
import com.ssginc.commonservice.product.entity.Product;
import com.ssginc.commonservice.store.entity.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Queue-ri
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    // 팝업스토어 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Store store;

    // 회원 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Member member;

    @Column(nullable = false)
    private Integer totalPrice;

    @Column(nullable = false)
    @ColumnDefault("PENDING")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime lastModifiedAt;

    // 주문에 연결된 주문상세
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
    private List<OrderDetail> orderDetailList = new ArrayList<>();

    public enum OrderStatus {
        PENDING, PAID, CANCELED, COMPLETED
    };
}
