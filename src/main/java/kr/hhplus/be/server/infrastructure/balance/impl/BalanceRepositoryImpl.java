package kr.hhplus.be.server.infrastructure.balance.impl;

import kr.hhplus.be.server.domain.balance.model.Balance;
import kr.hhplus.be.server.domain.balance.repository.BalanceRepository;
import kr.hhplus.be.server.infrastructure.balance.jpa.BalanceJpaRepository;
import kr.hhplus.be.server.infrastructure.balance.model.BalanceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BalanceRepositoryImpl implements BalanceRepository {

    private final BalanceJpaRepository balanceJpaRepository;

    @Override
    public Balance getUserBalance(Long userId) {
        BalanceEntity balance = balanceJpaRepository.findById(userId).get();
        return new Balance(balance.getUserId(), balance.getAmount());
    }

    @Override
    public void save(Balance userBalance) {
        BalanceEntity balanceEntity = new BalanceEntity(userBalance.getUserId(), userBalance.getAmount(), userBalance.getUpdateDate());
        balanceJpaRepository.save(balanceEntity);
    }
}
