package kr.hhplus.be.server.domain.coupon.service;

import kr.hhplus.be.server.domain.coupon.model.Coupon;
import kr.hhplus.be.server.domain.coupon.model.IssuedCoupon;
import kr.hhplus.be.server.domain.coupon.repository.CouponDetailRepository;
import kr.hhplus.be.server.domain.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;
    private final CouponDetailRepository couponDetailRepository;

    @Transactional
    public boolean getCoupon(IssuedCoupon issuedCoupon) {
        // 쿠폰 수량 및 존재여부 확인
        Coupon couponInfo = couponRepository.getCouponInfo(issuedCoupon.getCouponId());
        if(couponInfo != null && (couponInfo.getIssuedQuantity() < couponInfo.getMaxQuantity())) {
            // 최대쿠폰 수량 보다 발행된 수량이 적으므로 발급 가능
            couponDetailRepository.save(issuedCoupon);
            return true;
        }
        return false;
    }

    public List<IssuedCoupon> getUserIssuedCoupon(Long userId) {
        return couponDetailRepository.getUserIssuedCoupon(userId);
    }
}
