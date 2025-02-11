package com.ssginc.commonservice.store.entity;

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
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    @Column(nullable = false)
    private Long storeCategoryId;

    @Column(nullable = false, length = 100)
    private String storeName;

    @Column(nullable = false, length = 50)
    private String storeCategory;

    @Column(nullable = false, length = 50)
    private String storeAt;

    @Column(nullable = false, length = 200)
    private String storeShortDesc;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String storeLongDesc;

    @Column(nullable = false)
    private LocalDate storeStart;

    @Column(nullable = false)
    private LocalDate storeEnd;
}
