package kr.hhplus.be.server.infrastructure.balance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "balance")
public class BalanceEntity {

    @Id
    private Long userId;

    private Long amount;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;

    public BalanceEntity() {

    }

    public BalanceEntity(Long userId) {
        this.userId = userId;
        this.amount = 0L;
        this.registerDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    public BalanceEntity(Long userId, Long amount, LocalDateTime updateDate) {
        this.userId = userId;
        this.amount = amount;
        this.updateDate = updateDate;
    }


    public void charge(Long amount) {
        this.amount = this.amount + amount;
        this.registerDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

}

