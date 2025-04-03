package kr.hhplus.be.server.order.presentation.dto;

import kr.hhplus.be.server.product.presentation.dto.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Order {
    private long id;
    private List<Product> productList;
    private long userId;
    private long orderPrice;
    private long couponId;
    private long lastOrderPrice;
    private int status;

    public Order mockOrder(Order order) throws Exception {
        Product product = new Product();
        long couponId = ThreadLocalRandom.current().nextLong(1, 51);
        return new Order(1, product.mockProductList(), order.getUserId(), order.getOrderPrice(),
                couponId, (long) (order.getOrderPrice() - order.getOrderPrice() * 0.2), 1);
    }
}
