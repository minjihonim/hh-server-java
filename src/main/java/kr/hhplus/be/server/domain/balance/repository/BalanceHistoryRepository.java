package kr.hhplus.be.server.domain.balance.repository;

import kr.hhplus.be.server.domain.balance.model.BalanceHistory;
import org.springframework.stereotype.Repository;

@Repository
public class BalanceHistoryRepository {
    public Integer save(BalanceHistory balanceHistory) {
        return 1;
    }
}
