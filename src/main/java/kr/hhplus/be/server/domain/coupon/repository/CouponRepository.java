package kr.hhplus.be.server.domain.coupon.repository;

import kr.hhplus.be.server.domain.coupon.model.IssuedCoupon;
import org.springframework.stereotype.Repository;

@Repository
public class CouponRepository {

    public boolean save(IssuedCoupon issuedCoupon) {
        return true;
    }
}
