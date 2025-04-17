package kr.hhplus.be.server.domain.payment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    private Long id;

    private Long userId;

    private Long orderId;

    private Long amount;

    private String status;

    private String failReason;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;

    public Payment(Long orderId, Long amount, String stauts) {
        this.orderId = orderId;
        this.amount = amount;
        this.status = stauts;
    }
}
