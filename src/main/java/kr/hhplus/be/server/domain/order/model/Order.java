package kr.hhplus.be.server.domain.order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private Long id;

    private Long userId;

    private Long amount;

    private Long couponId;

    private Long finalAmount;

    private Long paymentId;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;

    public Order(Long userId, Long orderAmount, Long couponId, Long finalOrderAmount) {
        this.userId = userId;
        this.amount = orderAmount;
        this.couponId = couponId;
        this.finalAmount = finalOrderAmount;
    }

}
