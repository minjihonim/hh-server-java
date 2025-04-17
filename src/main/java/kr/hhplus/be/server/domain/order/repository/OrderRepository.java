package kr.hhplus.be.server.domain.order.repository;

import kr.hhplus.be.server.domain.order.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    public Long insertOrder(Order order) {
        return 1L;
    }
}
