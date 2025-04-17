package kr.hhplus.be.server.presentation.api.coupon;

import io.swagger.v3.oas.annotations.Operation;
import kr.hhplus.be.server.domain.coupon.service.CouponService;
import kr.hhplus.be.server.domain.coupon.model.IssuedCoupon;
import kr.hhplus.be.server.presentation.api.coupon.dto.CouponRequest;
import kr.hhplus.be.server.presentation.api.coupon.dto.CouponResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coupon")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    /**
     * 선착순 쿠폰 발급
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/request")
    @Operation(summary = "선착순 쿠폰 발급")
    public CouponResponse getCoupon(@RequestBody CouponRequest request) throws Exception {
        // 결과객체
        CouponResponse response = new CouponResponse();
        // 쿠폰발급
        IssuedCoupon issuedCoupon = request.toCoupon();
        boolean result = couponService.getCoupon(issuedCoupon);
        if(result) {
            response.setCode("0000");
            response.setMessage("발급완료");
            return response;
        }
        response.setCode("8888");
        response.setMessage("발급실패");
        return response;
    }
}
