package kr.hhplus.be.server.presentation.api.coupon.dto;

import kr.hhplus.be.server.domain.coupon.model.IssuedCoupon;
import lombok.Data;

@Data
public class CouponRequest {

    private Long userId;
    private Long couponId;

    public IssuedCoupon toCoupon() {
        IssuedCoupon issuedCoupon = new IssuedCoupon(userId, couponId);
        return issuedCoupon;
    }
}
