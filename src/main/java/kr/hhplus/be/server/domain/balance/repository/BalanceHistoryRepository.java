package kr.hhplus.be.server.domain.balance.repository;

import kr.hhplus.be.server.domain.balance.model.BalanceHistory;

public interface BalanceHistoryRepository {
    void save(BalanceHistory balanceHistory);
}
