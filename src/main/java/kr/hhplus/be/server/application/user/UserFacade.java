package kr.hhplus.be.server.application.user;

import kr.hhplus.be.server.domain.coupon.model.Coupon;
import kr.hhplus.be.server.domain.coupon.service.CouponService;
import kr.hhplus.be.server.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;
    private final CouponService couponService;

    public List<Coupon> getUserCoupon(Long userId) {
        return couponService.getUserIssuedCoupon(userId);
    }
}
