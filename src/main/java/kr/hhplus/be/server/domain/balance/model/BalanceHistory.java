package kr.hhplus.be.server.domain.balance.model;

import kr.hhplus.be.server.domain.balance.type.BalanceType;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BalanceHistory {

    private Long id;

    private Long userId;

    private Long amount;

    private BalanceType type;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;

    public BalanceHistory(Balance balance) {
        this.userId = balance.getUserId();
        this.amount = balance.getAmount();
        this.type = BalanceType.CHARGE;
        this.registerDate = balance.getRegisterDate();
        this.updateDate = balance.getUpdateDate();
    }

    public BalanceHistory() {

    }
}
