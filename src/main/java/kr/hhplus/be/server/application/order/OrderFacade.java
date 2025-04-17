package kr.hhplus.be.server.application.order;

import kr.hhplus.be.server.domain.order.model.Order;
import kr.hhplus.be.server.domain.order.service.OrderService;
import kr.hhplus.be.server.domain.payment.model.Payment;
import kr.hhplus.be.server.domain.payment.service.PaymentService;
import kr.hhplus.be.server.domain.product.model.Product;
import kr.hhplus.be.server.domain.product.ProductService;
import kr.hhplus.be.server.domain.product.model.ProductOption;
import kr.hhplus.be.server.domain.user.service.UserService;
import kr.hhplus.be.server.presentation.api.product.dto.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderFacade {

    private final UserService userService;
    private final ProductService productService;
    private final PaymentService paymentService;
    private final OrderService orderService;

    public boolean requestOrder(OrderCommand command) throws Exception {
        // 사용자 조회
        userService.checkUserInfo(command.getUserId());
        // 주문 상품 조회
        for(ProductOption productOption : command.getProductList()) {
            Integer checkProduct = productService.getProductCnt(productOption);
            if(checkProduct < 1) {
                return false;
            }
        }
        // 주문 등록
        Order order = command.toOrder();
        Long orderId = orderService.insertOrder(order);
        command.setId(orderId);
        // 결제 요청
        Payment payment = command.toPayment();
        paymentService.requestPayment(payment);

        return true;
    }
}
