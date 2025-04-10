package kr.hhplus.be.server.presentation.api.order.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import kr.hhplus.be.server.presentation.api.product.dto.ProductRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Order {
    @Schema(description = "주문 고유 아이디", example = "1")
    private long id;
    @Schema(description = "물품 리스트")
    private List<ProductRequest> productList;
    @Schema(description = "사용자 고유 아이디", example = "1")
    private long userId;
    @Schema(description = "주문 가격", example = "10000")
    private long orderPrice;
    @Schema(description = "쿠폰 고유 아이디", example = "1")
    private long couponId;
    @Schema(description = "최종 주문 가격", example = "8000")
    private long lastOrderPrice;
    @Schema(description = "주문 현황/상태", example = "1")
    private int status;

    public Order(int id, List<ProductRequest> productRequests, long userId, long orderPrice, long couponId, long lastOrderPrice, int status) {

    }

    public Order mockOrder(Order order) throws Exception {
        ProductRequest product = new ProductRequest();
        long couponId = ThreadLocalRandom.current().nextLong(1, 51);
        return new Order(1, product.mockProductList(), order.getUserId(), order.getOrderPrice(),
                couponId, (long) (order.getOrderPrice() - order.getOrderPrice() * 0.2), 1);
    }
}
