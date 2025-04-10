package kr.hhplus.be.server.application.order;

import kr.hhplus.be.server.domain.order.Order;
import kr.hhplus.be.server.domain.payment.Payment;
import kr.hhplus.be.server.domain.payment.type.PaymentType;
import kr.hhplus.be.server.presentation.api.product.dto.ProductRequest;
import lombok.Data;

import java.util.List;

@Data
public class OrderCommand {

    private Long id;

    private Long userId;

    private List<ProductRequest> productList;

    private Long orderPrice;

    private Long couponId;

    private Long finalOrderPrice;

    public Payment toPayment() {
        Payment payment = new Payment(this.id, this.userId, this.finalOrderPrice, PaymentType.FINISH.getMessage());
        return payment;
    }

    public Order toOrder() {
        Order order = new Order(this.userId, this.orderPrice, this.couponId, this.finalOrderPrice);
        return order;
    }
}
