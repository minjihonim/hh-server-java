package kr.hhplus.be.server.domain.coupon;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;
    private final CouponDetailRepository couponDetailRepository;

    public boolean getCoupon(Coupon coupon) {
        // 쿠폰 수량 및 존재여부 확인
        CouponDetail couponInfo = couponDetailRepository.getCouponInfo(coupon.getCouponId());
        if(couponInfo != null && (couponInfo.getIssuedQuantity() < couponInfo.getMaxQuantity())) {
            // 최대쿠폰 수량 보다 발행된 수량이 적으므로 발급 가능
            if(couponRepository.save(coupon)) {
                return true;
            }
        }
        return false;
    }
}
