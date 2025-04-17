package kr.hhplus.be.server.domain.coupon.repository;

import kr.hhplus.be.server.domain.coupon.model.Coupon;
import org.springframework.stereotype.Repository;

@Repository
public class CouponDetailRepository {
    public Coupon getCouponInfo(Long couponId) {
        return new Coupon().mockData();
    }
}
