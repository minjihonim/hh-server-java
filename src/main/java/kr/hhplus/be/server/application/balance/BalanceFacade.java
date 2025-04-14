package kr.hhplus.be.server.application.balance;

import kr.hhplus.be.server.domain.balance.service.BalanceService;
import kr.hhplus.be.server.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BalanceFacade {

    private final UserService userService;
    private final BalanceService balanceService;

    /**
     * 유저 포인트 충전
     * @param command
     * @return
     */
    public void charge(BalanceCommand command) throws Exception {
        // 사용자 조회
        userService.checkUserInfo(command.getUserId());
        // 잔액 충전
        balanceService.charge(command.getUserId(), command.getAmount());
    }
}
