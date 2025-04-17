package kr.hhplus.be.server.integration;

import kr.hhplus.be.server.ServerApplication;
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

}
