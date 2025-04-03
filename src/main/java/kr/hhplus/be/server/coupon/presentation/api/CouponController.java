package kr.hhplus.be.server.coupon.presentation.api;

import kr.hhplus.be.server.coupon.presentation.dto.Coupon;
import kr.hhplus.be.server.user.presentation.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    /**
     * 선착순 쿠폰 발급
     * @param userId
     * @return
     * @throws Exception
     */
    @GetMapping("/{userId}")
    public User getCoupon(@PathVariable("userId") long userId) throws Exception {
        return new Coupon().mockCoupon(userId);
    }
}
