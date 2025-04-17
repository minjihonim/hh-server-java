package kr.hhplus.be.server.infrastructure.balance.jpa;

import kr.hhplus.be.server.infrastructure.balance.model.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceJpaRepository extends JpaRepository<BalanceEntity, Long> {
}
