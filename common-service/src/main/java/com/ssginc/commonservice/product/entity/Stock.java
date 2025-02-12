package com.ssginc.commonservice.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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
public class Stock {
    // 재고와 연결된 상품
    @Id
    @OneToOne
    @JoinColumn(name = "product_id", unique = true)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer soldCount;

    @Column(nullable = false)
    private LocalDate lastRestockDate;
}
