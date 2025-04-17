package kr.hhplus.be.server.infrastructure.coupon.impl;

import kr.hhplus.be.server.domain.coupon.model.IssuedCoupon;
import kr.hhplus.be.server.domain.coupon.repository.CouponDetailRepository;
import kr.hhplus.be.server.infrastructure.coupon.jpa.CouponDetailJpaRepository;
import kr.hhplus.be.server.infrastructure.coupon.model.IssuedCouponEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CouponDetailRepositoryImpl implements CouponDetailRepository {

    private final CouponDetailJpaRepository couponDetailJpaRepository;

    @Override
    public boolean save(IssuedCoupon issuedCoupon) {
        IssuedCouponEntity issuedCouponEntity = new IssuedCouponEntity(issuedCoupon.getUserId(), issuedCoupon.getCouponId(),
                LocalDateTime.now());
        couponDetailJpaRepository.save(issuedCouponEntity);
        return true;
    }

    @Override
    public List<IssuedCoupon> getUserIssuedCoupon(Long userId) {
        return null;
    }
}
