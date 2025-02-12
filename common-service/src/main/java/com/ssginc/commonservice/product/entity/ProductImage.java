package com.ssginc.commonservice.product.entity;

import com.ssginc.commonservice.store.entity.Store;
import com.ssginc.commonservice.store.entity.StoreCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Queue-ri
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productImageId;

    // 상품 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Product product;

    @Column(nullable = false, length = 50)
    private String productImageTag;

    @Column(nullable = false, length = 500)
    private String productImageLink;
}
