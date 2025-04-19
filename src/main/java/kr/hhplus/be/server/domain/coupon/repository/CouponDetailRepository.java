package kr.hhplus.be.server.domain.coupon.repository;

import kr.hhplus.be.server.domain.coupon.model.IssuedCoupon;

import java.util.List;

public interface CouponDetailRepository {

    boolean save(IssuedCoupon issuedCoupon);

    List<IssuedCoupon> getUserIssuedCoupon(Long userId);
}
