package kr.hhplus.be.server.unit;

import kr.hhplus.be.server.domain.order.model.Order;
import kr.hhplus.be.server.domain.order.repository.OrderRepository;
import kr.hhplus.be.server.domain.order.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderUnitTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    @DisplayName("주문 등록 테스트")
    public void orderProductTest() {
        // given
        Long userId = 1L;
        Long couponId = 1L;
        Order order = new Order(userId, 10000L, couponId, 9000L);
        // when
        when(orderRepository.insertOrder(order)).thenReturn(1L);
        Long orderId = orderService.insertOrder(order);
        // then
        assertEquals(1L, orderId);
    }

}
