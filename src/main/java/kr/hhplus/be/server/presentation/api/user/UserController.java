package kr.hhplus.be.server.presentation.api.user;

import kr.hhplus.be.server.application.user.UserCommand;
import kr.hhplus.be.server.application.user.UserFacade;
import kr.hhplus.be.server.presentation.api.user.dto.UserCouponResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    /**
     * 사용자 보유 쿠폰 조회
     */
    @GetMapping("/coupon/{id}")
    public UserCouponResponse getUserCoupon(@PathVariable Long id) {
        UserCommand userCouponInfo = userFacade.getUserCoupon(id);
        return new UserCouponResponse().makeResult(userCouponInfo);
    }
}
