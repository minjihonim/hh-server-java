package kr.hhplus.be.server.domain.coupon.repository;

import kr.hhplus.be.server.domain.coupon.model.IssuedCoupon;

public interface CouponDetailRepository {

    boolean save(IssuedCoupon issuedCoupon);
}
