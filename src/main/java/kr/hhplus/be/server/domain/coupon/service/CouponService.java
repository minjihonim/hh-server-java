package kr.hhplus.be.server.domain.coupon.service;

import kr.hhplus.be.server.domain.coupon.model.Coupon;
import kr.hhplus.be.server.domain.coupon.model.IssuedCoupon;
import kr.hhplus.be.server.domain.coupon.repository.CouponDetailRepository;
import kr.hhplus.be.server.domain.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Coupon> getUserIssuedCoupon(Long userId) {
        // 유저가 발급 받은 쿠폰 조회
        List<IssuedCoupon> userIssuedCouponList = couponDetailRepository.getUserIssuedCoupon(userId);
        // 쿠폰정보 조회
        List<Long> varCouponIdList = userIssuedCouponList.stream()
                .map(IssuedCoupon::getCouponId)
                .toList();
        return couponRepository.getCouponInfoList(varCouponIdList);
    }
}
