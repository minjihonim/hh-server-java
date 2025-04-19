package kr.hhplus.be.server.presentation.api.user.dto;

import kr.hhplus.be.server.domain.coupon.model.Coupon;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;

@Data
public class UserCouponResponse {

    private String code;
    private String message;
    private Long userId;
    private List<UserCouponInfo> couponList;

    public UserCouponResponse fromCoupon(List<Coupon> userCouponList, Long userId) {
        ModelMapper modelMapper = new ModelMapper();
        this.code = "0000";
        this.message = "사용자 쿠폰조회 성공";
        this.userId = userId;
        this.couponList = Collections.singletonList(modelMapper.map(userCouponList, UserCouponInfo.class));
        return this;
    }
}
