package com.ssginc.reserveservice.reserve.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
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
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    // store

    // member

    private LocalDateTime reservedDateTime;

    @Column(nullable = false)
    private Integer headcount;

    @Column(nullable = false)
    @ColumnDefault("PENDING")
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    public enum ReservationStatus {
        PENDING, CONFIRMED, CANCELED
    };
}
