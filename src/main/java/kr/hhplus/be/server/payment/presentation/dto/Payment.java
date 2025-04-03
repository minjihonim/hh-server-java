package kr.hhplus.be.server.payment.presentation.dto;

import kr.hhplus.be.server.order.presentation.dto.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Payment {
    private long id;
    private long userId;
    private List<Order> orderList;
    private long paymentAmount;
    private int status;

    public Payment mockPayment(Payment payment) throws Exception {
        Order paramOrder = new Order(1, new ArrayList<>(), 1, 30000L, 0, 0, 0);
        Order resultOrder = new Order().mockOrder(paramOrder);
        List<Order> orderList = new ArrayList<>();
        orderList.add(resultOrder);
        return new Payment(1, payment.getUserId(), orderList, resultOrder.getLastOrderPrice(), 1);
    }
}
