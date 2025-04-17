package kr.hhplus.be.server.domain.balance.repository;

import kr.hhplus.be.server.domain.balance.model.Balance;


public interface BalanceRepository {


    public Balance getUserBalance(Long userId);

    void save(Balance userBalance);
}
