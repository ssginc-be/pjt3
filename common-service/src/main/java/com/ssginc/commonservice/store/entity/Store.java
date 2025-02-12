package com.ssginc.commonservice.store.entity;

import com.ssginc.commonservice.member.entity.MemberStore;
import com.ssginc.commonservice.order.entity.Orders;
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
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    // 팝업스토어 카테고리 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private StoreCategory storeCategory;

    @Column(nullable = false, length = 100)
    private String storeName;

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

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    // 팝업스토어 이미지
    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
    private List<StoreImage> storeImageList;

    // 팝업스토어 공지사항
    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
    private List<StoreAnnouncement> storeAnnouncementList;

    // 팝업스토어에 연결된 회원(운영자) 계정
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
    private List<MemberStore> memberStoreList = new ArrayList<>();

    // 팝업스토어에 연결된 상품
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
    private List<Product> productList = new ArrayList<>();

    // 팝업스토어에 연결된 주문
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
    private List<Orders> orderList = new ArrayList<>();
}
