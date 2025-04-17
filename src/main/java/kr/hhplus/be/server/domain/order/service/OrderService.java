package kr.hhplus.be.server.domain.order.service;

import kr.hhplus.be.server.domain.order.model.Order;
import kr.hhplus.be.server.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Long insertOrder(Order order) {
        return orderRepository.insertOrder(order);
    }
}
