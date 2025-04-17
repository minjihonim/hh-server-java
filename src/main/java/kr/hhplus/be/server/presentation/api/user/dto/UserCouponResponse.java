package kr.hhplus.be.server.presentation.api.user.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserCouponResponse {
    private String code;
    private String message;
    private Long userId;
    private List<Long> couponIdList;
}
