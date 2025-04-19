package kr.hhplus.be.server.application.user;

import kr.hhplus.be.server.application.user.dto.UserCouponCommand;
import kr.hhplus.be.server.domain.coupon.model.Coupon;
import kr.hhplus.be.server.domain.coupon.model.IssuedCoupon;
import kr.hhplus.be.server.domain.coupon.service.CouponService;
import kr.hhplus.be.server.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private UserService userService;
    private CouponService couponService;

    public UserCommand getUserCoupon(Long userId) {
        List<Coupon> userCouponList =  couponService.getUserIssuedCoupon(userId);
        return new UserCommand().makeResult(userCouponList, userId);
    }
}
