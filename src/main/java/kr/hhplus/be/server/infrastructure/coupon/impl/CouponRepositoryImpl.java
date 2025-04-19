package kr.hhplus.be.server.infrastructure.coupon.impl;

import kr.hhplus.be.server.domain.coupon.model.Coupon;
import kr.hhplus.be.server.domain.coupon.repository.CouponRepository;
import kr.hhplus.be.server.infrastructure.coupon.jpa.CouponJpaRepository;
import kr.hhplus.be.server.infrastructure.coupon.model.CouponEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CouponRepositoryImpl implements CouponRepository {

    private final CouponJpaRepository couponJpaRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Coupon getCouponInfo(Long couponId) {
        CouponEntity couponEntity = couponJpaRepository.findById(couponId).orElse(null);
        return new Coupon(couponEntity.getId(), couponEntity.getName(), couponEntity.getDiscount(),
                couponEntity.getMaxQuantity(), couponEntity.getIssuedQuantity(), couponEntity.getExpirationDay());
    }

    @Override
    public List<Coupon> getCouponInfoList(List<Long> varCouponIdList) {
        List<CouponEntity> couponInfoList = couponJpaRepository.findAllById(varCouponIdList);
        return Collections.singletonList(modelMapper.map(couponInfoList, Coupon.class));
    }
}
