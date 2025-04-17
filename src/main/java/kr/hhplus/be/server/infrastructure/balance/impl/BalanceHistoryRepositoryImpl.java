package kr.hhplus.be.server.infrastructure.balance.impl;

import kr.hhplus.be.server.domain.balance.model.BalanceHistory;
import kr.hhplus.be.server.domain.balance.repository.BalanceHistoryRepository;
import kr.hhplus.be.server.domain.balance.type.BalanceType;
import kr.hhplus.be.server.infrastructure.balance.jpa.BalanceHistoryJpaRepository;
import kr.hhplus.be.server.infrastructure.balance.model.BalanceHistoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor
public class BalanceHistoryRepositoryImpl implements BalanceHistoryRepository {

    private final BalanceHistoryJpaRepository balanceHistoryJpaRepository;

    @Override
    public void save(BalanceHistory balanceHistory) {
        BalanceHistoryEntity balanceHistoryEntity = new BalanceHistoryEntity(balanceHistory.getUserId(), balanceHistory.getAmount(),
                BalanceType.CHARGE, LocalDateTime.now());
        balanceHistoryJpaRepository.save(balanceHistoryEntity);
    }
}
