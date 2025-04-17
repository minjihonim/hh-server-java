package kr.hhplus.be.server.infrastructure.coupon.impl;

import kr.hhplus.be.server.domain.coupon.model.Coupon;
import kr.hhplus.be.server.domain.coupon.repository.CouponRepository;
import kr.hhplus.be.server.infrastructure.coupon.jpa.CouponJpaRepository;
import kr.hhplus.be.server.infrastructure.coupon.model.CouponEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CouponRepositoryImpl implements CouponRepository {

    private final CouponJpaRepository couponJpaRepository;

    @Override
    public Coupon getCouponInfo(Long couponId) {
        CouponEntity couponEntity = couponJpaRepository.findById(couponId).orElse(null);
        return new Coupon(couponEntity.getId(), couponEntity.getName(), couponEntity.getDiscount(),
                couponEntity.getMaxQuantity(), couponEntity.getIssuedQuantity(), couponEntity.getExpirationDay());
    }
}
