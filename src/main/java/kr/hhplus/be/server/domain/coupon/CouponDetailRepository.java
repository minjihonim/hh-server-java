package kr.hhplus.be.server.domain.coupon;

import org.springframework.stereotype.Repository;

@Repository
public class CouponDetailRepository {
    public CouponDetail getCouponInfo(Long couponId) {
        return new CouponDetail().mockData();
    }
}
