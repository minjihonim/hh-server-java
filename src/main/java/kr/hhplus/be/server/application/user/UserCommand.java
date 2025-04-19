package kr.hhplus.be.server.application.user;

import kr.hhplus.be.server.application.user.dto.UserCouponCommand;
import kr.hhplus.be.server.domain.coupon.model.Coupon;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;

@Data
public class UserCommand {

    private final ModelMapper modelMapper = new ModelMapper();

    private Long userId;
    private List<UserCouponCommand> counponList;

    public UserCommand makeResult(List<Coupon> coupons, Long userId) {
        this.counponList = Collections.singletonList(modelMapper.map(coupons, UserCouponCommand.class));
        this.userId = userId;
        return this;
    }
}
