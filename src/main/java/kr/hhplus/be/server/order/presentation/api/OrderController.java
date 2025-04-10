package kr.hhplus.be.server.order.presentation.api;

import io.swagger.v3.oas.annotations.Operation;
import kr.hhplus.be.server.order.presentation.dto.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order/")
public class OrderController {

    /**
     * 주문 처리
     * @param param
     * @return
     * @throws Exception
     */
    @PostMapping("/request")
    @Operation(summary = "주문 처리")
    public Order requestOrder(@RequestBody Order param) throws Exception {
        return new Order().mockOrder(param);
    }
}
