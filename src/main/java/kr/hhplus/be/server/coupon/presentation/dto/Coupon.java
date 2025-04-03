package kr.hhplus.be.server.coupon.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import kr.hhplus.be.server.user.presentation.dto.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Coupon {
    @Schema(description = "쿠폰ID", example = "1")
    private long id;
    @Schema(description = "할인율", example = "10")
    private long discountRate;
    @Schema(description = "반출 상태", example = "0")
    private int status;

    public User mockCoupon(long userId) throws Exception {
        long couponId = ThreadLocalRandom.current().nextLong(1, 51);
        Coupon coupon = new Coupon(couponId, 20L, 1);
        return new User(userId, "홍길동", coupon.getId());
    }
}
