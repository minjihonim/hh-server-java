package kr.hhplus.be.server.domain.coupon.repository;

import kr.hhplus.be.server.domain.coupon.model.Coupon;

public interface CouponRepository {

    Coupon getCouponInfo(Long couponId);

}
