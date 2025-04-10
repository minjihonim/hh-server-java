package kr.hhplus.be.server.domain.payment;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Payment {
    @Id
    private Long id;

    private Long orderId;

    private Long userId;

    private Long amount;

    private String status;

    private String failReason;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;

    public Payment(Long orderId, Long userId, Long amount, String stauts) {
        this.orderId = orderId;
        this.userId = userId;
        this.amount = amount;
        this.status = stauts;
        this.registerDate = LocalDateTime.now();
    }

    public Payment() {

    }
}
