package kr.hhplus.be.server.domain.balance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Balance {

    @Id
    private Long userId;

    private Long amount;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;

    public Balance() {

    }

    public Balance(Long userId) {
        this.userId = userId;
        this.amount = 0L;
        this.registerDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }


    public void charge(Long amount) {
        this.amount = this.amount + amount;
        this.registerDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

}
