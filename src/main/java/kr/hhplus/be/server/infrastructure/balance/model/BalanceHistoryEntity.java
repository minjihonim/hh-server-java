package kr.hhplus.be.server.infrastructure.balance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import kr.hhplus.be.server.domain.balance.type.BalanceType;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class BalanceHistoryEntity {

    @Id
    private Long id;

    private Long userId;

    private Long amount;

    private BalanceType type;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;


    public BalanceHistoryEntity(Long userId, Long amount, BalanceType balanceType, LocalDateTime now) {
        this.userId = userId;
        this.amount = amount;
        this.type = balanceType;
        this.updateDate = now;
    }
}
