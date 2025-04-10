package kr.hhplus.be.server;

import kr.hhplus.be.server.domain.balance.*;
import kr.hhplus.be.server.domain.user.User;
import kr.hhplus.be.server.domain.user.UserRepository;
import kr.hhplus.be.server.domain.user.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChargeUnitTest {

    @Mock
    private BalanceRepository balanceRepository;

    @Mock
    private BalanceHistoryRepository balanceHistoryRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private BalanceService balanceService;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("충전 요청시 존재하지 않는 유저가 있을 경우 충전 실패")
    public void testChargeNotUser() throws Exception {
        // given
        Long userId = null;

        // when
        when(userRepository.getUserInfo(userId)).thenReturn(null);

        // then
        assertThatThrownBy(() -> {
            userService.checkUserInfo(userId);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("충전 성공 유닛 테스트")
    public void testCharge() throws Exception {
        // given
        Long userId = 1L;
        Long amount = 10L;
        Balance balance = new Balance(userId);
        balance.charge(amount);

        // when
        when(balanceRepository.getUserBalance(userId)).thenReturn(balance);
        balanceService.charge(userId, amount);
    }

}
