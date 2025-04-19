package kr.hhplus.be.server.infrastructure.coupon.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "issued_coupon")
@Getter
@NoArgsConstructor
public class IssuedCouponEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long couponId;

    private LocalDate usedDate;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;

    public IssuedCouponEntity(Long userId, Long couponId, LocalDateTime now) {
        this.userId = userId;
        this.couponId = couponId;
        this.registerDate = now;
    }
}
