package kr.hhplus.be.server.application.order;

import kr.hhplus.be.server.domain.order.model.Order;
import kr.hhplus.be.server.domain.payment.model.Payment;
import kr.hhplus.be.server.domain.payment.type.PaymentType;
import kr.hhplus.be.server.domain.product.model.ProductOption;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderCommand {

    private Long id;

    private Long userId;

    private List<ProductOption> productList = new ArrayList<>();

    private Long orderPrice;

    private Long couponId;

    private Long finalOrderPrice;

    public Payment toPayment() {
        Payment payment = new Payment(this.id, this.finalOrderPrice, PaymentType.FINISH.getMessage());
        return payment;
    }

    public Order toOrder() {
        Order order = new Order(this.userId, this.orderPrice, this.couponId, this.finalOrderPrice);
        return order;
    }
}
