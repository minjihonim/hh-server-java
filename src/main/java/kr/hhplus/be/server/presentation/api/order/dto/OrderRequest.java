package kr.hhplus.be.server.presentation.api.order.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import kr.hhplus.be.server.application.order.OrderCommand;
import kr.hhplus.be.server.presentation.api.product.dto.ProductRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class OrderRequest {
    @Schema(description = "물품 리스트")
    private List<ProductRequest> productList;
    @Schema(description = "사용자 고유 아이디", example = "1")
    private Long userId;
    @Schema(description = "주문 가격", example = "10000")
    private Long orderPrice;
    @Schema(description = "쿠폰 고유 아이디", example = "1")
    private Long couponId;
    @Schema(description = "최종 주문 가격", example = "8000")
    private Long finalOrderPrice;

    public OrderRequest(List<ProductRequest> productRequests, Long userId, Long orderPrice, Long couponId, Long lastOrderPrice) {

    }

    public <E> OrderRequest(int i, ArrayList<E> es, int i1, Long l, int i2, int i3) {

    }

    public OrderCommand toOrderCommand() {
        OrderCommand command = new OrderCommand();
        command.setUserId(userId);
        command.setOrderPrice(orderPrice);
        command.setCouponId(couponId);
        command.setFinalOrderPrice(finalOrderPrice);
        return command;
    }
}
