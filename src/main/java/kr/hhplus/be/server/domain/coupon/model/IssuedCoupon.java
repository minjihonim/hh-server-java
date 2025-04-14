package kr.hhplus.be.server.domain.coupon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
public class IssuedCoupon {

    @Id
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

    public IssuedCoupon() {

    }

}
