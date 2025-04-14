package kr.hhplus.be.server.unit;

import kr.hhplus.be.server.domain.coupon.repository.CouponDetailRepository;
import kr.hhplus.be.server.domain.coupon.repository.CouponRepository;
import kr.hhplus.be.server.domain.coupon.service.CouponService;
import kr.hhplus.be.server.domain.coupon.model.Coupon;
import kr.hhplus.be.server.domain.coupon.model.IssuedCoupon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CouponUnitTest {

    @Mock
    private CouponRepository couponRepository;

    @Mock
    private CouponDetailRepository couponDetailRepository;

    @InjectMocks
    private CouponService couponService;

    @Test
    @DisplayName("선착순 쿠폰 발급 테스트")
    void couponTest() {
        // given
        Long userId = 1L;
        Long couponId = 1L;
        IssuedCoupon issuedCoupon = new IssuedCoupon(userId, couponId);
        Coupon coupon = new Coupon().mockData();
        // when
        when(couponDetailRepository.getCouponInfo(issuedCoupon.getCouponId())).thenReturn(coupon);
        when(couponRepository.save(issuedCoupon)).thenReturn(true);
        boolean result = couponService.getCoupon(issuedCoupon);

        // then
        assertEquals(true, result);

    }
}
