package kr.hhplus.be.server.presentation.api.coupon;

import io.swagger.v3.oas.annotations.Operation;
import kr.hhplus.be.server.presentation.api.coupon.dto.Coupon;
import kr.hhplus.be.server.presentation.api.user.dto.User;
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
    @Operation(summary = "선착순 쿠폰 발급")
    public User getCoupon(@PathVariable("userId") long userId) throws Exception {
        return new Coupon().mockCoupon(userId);
    }
}
