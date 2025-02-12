package com.ssginc.commonservice.product.entity;

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
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productCategoryId;

    @Column(nullable = false, length = 30)
    private String productCategoryName;

    @Column(length = 100)
    private String productCategoryDesc;

    // 해당 카테고리에 연결된 상품
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productCategory")
    private List<Product> productList = new ArrayList<>();
}
