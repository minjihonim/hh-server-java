package kr.hhplus.be.server.presentation.api.payment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import kr.hhplus.be.server.presentation.api.order.dto.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Payment {
    @Schema(description = "결제 고유 아이디", example = "1")
    private long id;
    @Schema(description = "사용자 고유 아이디", example = "1")
    private long userId;
    @Schema(description = "주문 목록", example = "3")
    private List<Order> orderList;
    @Schema(description = "결제 금액", example = "250000")
    private long paymentAmount;
    @Schema(description = "결제 현황/상태", example = "1")
    private int status;

    public Payment mockPayment(Payment payment) throws Exception {
        Order paramOrder = new Order(1, new ArrayList<>(), 1, 30000L, 0, 0, 0);
        Order resultOrder = new Order().mockOrder(paramOrder);
        List<Order> orderList = new ArrayList<>();
        orderList.add(resultOrder);
        return new Payment(1, payment.getUserId(), orderList, resultOrder.getLastOrderPrice(), 1);
    }
}
