package kr.hhplus.be.server.coupon.presentation.dto;

import kr.hhplus.be.server.user.presentation.dto.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Coupon {
    private long id;
    private long discountRate;
    private int status;

    public User mockCoupon(long userId) throws Exception {
        long couponId = ThreadLocalRandom.current().nextLong(1, 51);
        Coupon coupon = new Coupon(couponId, 20L, 1);
        return new User(userId, "홍길동", coupon.getId());
    }
}
