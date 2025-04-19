package kr.hhplus.be.server.presentation.api.user.dto;

import kr.hhplus.be.server.application.user.UserCommand;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;

@Data
public class UserCouponResponse {

    private final ModelMapper modelMapper = new ModelMapper();

    private String code;
    private String message;
    private Long userId;
    private List<UserCouponInfo> couponList;

    public UserCouponResponse makeResult(UserCommand command) {
        this.code = "0000";
        this.message = "사용자 쿠폰조회 성공";
        this.userId = command.getUserId();
        this.couponList = Collections.singletonList(modelMapper.map(command.getCounponList(), UserCouponInfo.class));
        return this;
    }
}
