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

    private Long price;

    private Long couponId;

    private Long finalPrice;

    private Long paymentId;

    private Long productId;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;

    public Order(Long userId, Long orderPrice, Long couponId, Long finalOrderPrice) {
        this.userId = userId;
        this.price = orderPrice;
        this.couponId = couponId;
        this.finalPrice = finalOrderPrice;
    }

}
