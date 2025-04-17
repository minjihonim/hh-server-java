package kr.hhplus.be.server.unit;

import kr.hhplus.be.server.domain.balance.model.Balance;
import kr.hhplus.be.server.domain.balance.repository.BalanceRepository;
import kr.hhplus.be.server.domain.balance.service.BalanceService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BalanceUnitTest {

    @Mock
    private BalanceRepository balanceRepository;

    @InjectMocks
    private BalanceService balanceService;

    @Test
    @DisplayName("유저 잔액 조회 테스트")
    public void getBalanaceTest() throws Exception {
        // given
        long userId = 1L;

        // when
        when(balanceRepository.getUserBalance(userId)).thenReturn(new Balance(userId));
        Balance result = balanceService.getPoint(userId);

        // then
        assertEquals(userId, result.getUserId());
        assertEquals(0L, result.getAmount());

    }
}
