package com.ssginc.commonservice.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

/**
 * @author Queue-ri
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeCategoryId;

    // 팝업스토어
    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "storeCategory") // 자바 코드 상의 필드명
    private List<Store> storeList;

    @Column(nullable = false, length = 20)
    private String storeCategoryName;

    @Column(length = 100)
    private String storeCategoryDesc;
}
