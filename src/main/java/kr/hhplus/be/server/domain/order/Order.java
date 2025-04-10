package kr.hhplus.be.server.domain.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Order {

    @Id
    private Long id;

    private long userId;

    private long orderPrice;

    private Long couponId;

    private long finalOrderPrice;

    public Order(long userId, long orderPrice, Long couponId, long finalOrderPrice) {
        this.userId = userId;
        this.orderPrice = orderPrice;
        this.couponId = couponId;
        this.finalOrderPrice = finalOrderPrice;
    }

    public Order() {

    }
}
