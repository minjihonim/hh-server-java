package kr.hhplus.be.server.unit;

import kr.hhplus.be.server.domain.coupon.*;
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
        Coupon coupon = new Coupon(userId, couponId);
        CouponDetail couponDetail = new CouponDetail().mockData();
        // when
        when(couponDetailRepository.getCouponInfo(coupon.getCouponId())).thenReturn(couponDetail);
        when(couponRepository.save(coupon)).thenReturn(true);
        boolean result = couponService.getCoupon(coupon);

        // then
        assertEquals(true, result);

    }
}
