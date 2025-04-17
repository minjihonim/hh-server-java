package kr.hhplus.be.server.domain.coupon.model;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class IssuedCoupon {

    private Long id;

    private Long userId;

    private Long couponId;

    private LocalDate usedDate;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;

    public IssuedCoupon(Long userId, Long couponId) {
        this.userId = userId;
        this.couponId = couponId;
    }

}
