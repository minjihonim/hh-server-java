package kr.hhplus.be.server.integration;

import kr.hhplus.be.server.ServerApplication;
import kr.hhplus.be.server.domain.coupon.model.IssuedCoupon;
import kr.hhplus.be.server.domain.coupon.service.CouponService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ServerApplication.class)
public class CouponIntegrationTest {

    @Autowired
    private CouponService couponService;

    @Test
    @DisplayName("선착순 쿠폰 발급 성공 테스트")
    void getCouponTest() {
        // given
        long userId = 1L;
        long couponId = 1L;
        IssuedCoupon coupon = new IssuedCoupon(userId, couponId);

        // when
        couponService.getCoupon(coupon);


    }
}
