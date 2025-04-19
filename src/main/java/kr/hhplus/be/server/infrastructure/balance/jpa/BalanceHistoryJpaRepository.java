package kr.hhplus.be.server.infrastructure.balance.jpa;

import kr.hhplus.be.server.infrastructure.balance.model.BalanceHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceHistoryJpaRepository extends JpaRepository<BalanceHistoryEntity, Long> {
}
