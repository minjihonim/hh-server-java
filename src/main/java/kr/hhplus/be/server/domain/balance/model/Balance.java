package kr.hhplus.be.server.domain.balance.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Balance {

    private Long userId;

    private Long amount;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;

    public Balance(Long userId) {
        this.userId = userId;
        this.amount = 0L;
        this.registerDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    public Balance(Long userId, Long amount, LocalDateTime registerDate) {
        this.userId = userId;
        this.amount = amount;
        this.registerDate = registerDate;
    }

    public void charge(Long amount) {
        this.amount = this.amount + amount;
        this.updateDate = LocalDateTime.now();
    }

}
