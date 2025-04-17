package kr.hhplus.be.server.presentation.api.order;

import io.swagger.v3.oas.annotations.Operation;
import kr.hhplus.be.server.application.order.OrderCommand;
import kr.hhplus.be.server.application.order.OrderFacade;
import kr.hhplus.be.server.presentation.api.order.dto.OrderRequest;
import kr.hhplus.be.server.presentation.api.order.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order/")
@RequiredArgsConstructor
public class OrderController {

    private final OrderFacade orderFacade;

    /**
     * 주문 처리
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/request")
    @Operation(summary = "주문 처리")
    public OrderResponse requestOrder(@RequestBody OrderRequest request) throws Exception {
        OrderResponse response = new OrderResponse();
        OrderCommand command = request.toOrderCommand();
        boolean result = orderFacade.requestOrder(command);
        if(result) {
            response.setCode("0000");
            response.setMessage("주문완료");
            return response;
        }
        response.setCode("9999");
        response.setMessage("주문실패");
        return response;
    }
}
