package kr.hhplus.be.server.presentation.api.coupon.dto;

import kr.hhplus.be.server.domain.coupon.Coupon;
import kr.hhplus.be.server.domain.coupon.CouponDetail;
import lombok.Data;

@Data
public class CouponRequest {

    private Long userId;
    private Long couponId;

    public Coupon toCoupon() {
        Coupon coupon = new Coupon(userId, couponId);
        return coupon;
    }
}
