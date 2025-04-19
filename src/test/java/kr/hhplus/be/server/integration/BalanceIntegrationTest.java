package kr.hhplus.be.server.integration;

import kr.hhplus.be.server.ServerApplication;
import kr.hhplus.be.server.application.balance.BalanceCommand;
import kr.hhplus.be.server.application.balance.BalanceFacade;
import kr.hhplus.be.server.domain.balance.model.Balance;
import kr.hhplus.be.server.domain.balance.service.BalanceService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ServerApplication.class)
public class BalanceIntegrationTest {

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private BalanceFacade balanceFacade;

    @Test
    @DisplayName("잔액 조회 통합 테스트")
    public void getBalanceTest() {
        // given
        Long userId = 1L;
        Long amount = 10L;

        // when
        Balance result = balanceService.getPoint(userId);

        // then
        assertEquals(userId, result.getUserId());
        assertEquals(amount, result.getAmount());
    }

    @Test
    @DisplayName("잔액 충전 통합 테스트")
    public void chargeBalanceTest() {
        // given
        Long userId = 1L;
        Long chargeAmount = 10L;
        BalanceCommand command = new BalanceCommand();
        command.setUserId(userId);
        command.setAmount(chargeAmount);

        // when
        Balance beforeUserBalance = balanceService.getPoint(userId);
        balanceFacade.charge(command);
        Balance afterUserBalance = balanceService.getPoint(userId);

        // then
        assertEquals(beforeUserBalance.getAmount() + chargeAmount, afterUserBalance.getAmount());
    }

}
