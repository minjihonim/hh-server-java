package kr.hhplus.be.server.domain.payment.model;

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

    private Long price;

    private String status;

    private String failReason;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;

    public Payment(Long orderId, Long price, String stauts) {
        this.orderId = orderId;
        this.price = price;
        this.status = stauts;
    }

    public Payment() {

    }
}
