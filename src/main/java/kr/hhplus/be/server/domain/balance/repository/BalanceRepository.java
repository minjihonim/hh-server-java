package kr.hhplus.be.server.domain.balance.repository;

import kr.hhplus.be.server.domain.balance.model.Balance;
import org.springframework.stereotype.Repository;

@Repository
public class BalanceRepository {

    public Balance getUserBalance(Long userId) {
        return new Balance(userId);
    }

    public Integer save(Balance balance) {
        return 1;
    }
}
