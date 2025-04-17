package kr.hhplus.be.server.infrastructure.balance.model;

import jakarta.persistence.*;
import kr.hhplus.be.server.domain.balance.type.BalanceType;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name = "balance_history")
public class BalanceHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        this.registerDate = now;
    }
}
