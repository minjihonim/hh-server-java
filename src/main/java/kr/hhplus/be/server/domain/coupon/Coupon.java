package kr.hhplus.be.server.domain.coupon;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
public class Coupon {

    @Id
    private Long id;

    private Long userId;

    private Long couponId;

    private LocalDate expirationDate;

    private LocalDateTime usedDate;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;

    public Coupon(Long userId, Long couponId) {
        this.userId = userId;
        this.couponId = couponId;
    }

    public Coupon() {

    }

}
