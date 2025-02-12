package com.ssginc.commonservice.product.entity;

import com.ssginc.commonservice.member.entity.MemberStore;
import com.ssginc.commonservice.order.entity.OrderDetail;
import com.ssginc.commonservice.store.entity.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    // 팝업스토어 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Store store;

    // 상품 카테고리 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private ProductCategory productCategory;

    @Column(nullable = false, length = 100)
    private String productName;

    @Column(nullable = false)
    private Integer productPrice;

    @Column(nullable = false, length = 300)
    private String productShortDesc;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String productLongDesc;

    // 상품에 연결된 상품 이미지
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductImage> productImage;

    // 상품에 연결된 주문상세
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<OrderDetail> orderDetailList = new ArrayList<>();
}
