package kr.hhplus.be.server.domain.balance.service;

import kr.hhplus.be.server.domain.balance.model.Balance;
import kr.hhplus.be.server.domain.balance.model.BalanceHistory;
import kr.hhplus.be.server.domain.balance.repository.BalanceHistoryRepository;
import kr.hhplus.be.server.domain.balance.repository.BalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BalanceService {

    private final BalanceRepository balanceRepository;
    private final BalanceHistoryRepository balanceHistoryRepository;

    @Transactional
    public void charge(Long userId, Long amount) {
        // 유저 보유금액 조회
        Balance userBalance = balanceRepository.getUserBalance(userId);
        // 유저 금액 충전
        userBalance.charge(amount);
        balanceRepository.save(userBalance);
        // 유저 금액 히스토리 등록
        BalanceHistory balanceHistory = new BalanceHistory(userBalance);
        balanceHistoryRepository.save(balanceHistory);
    }

    public Balance getPoint(Long userId) {
        // 유저 보유금액 조회
        return balanceRepository.getUserBalance(userId);
    }
}
