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

import java.time.LocalDateTime;

/**
 * @author Queue-ri
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailId;

    // 주문 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Orders orders;

    // 상품 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Product product;

    @Column(nullable = false)
    private Integer orderQuantity; // 주문 수량

    @Column(nullable = false)
    private Integer orderPrice; // 상품 개별 가격
}
