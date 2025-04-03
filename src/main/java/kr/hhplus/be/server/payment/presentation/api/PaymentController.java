package kr.hhplus.be.server.payment.presentation.api;

import io.swagger.v3.oas.annotations.Operation;
import kr.hhplus.be.server.payment.presentation.dto.Payment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    /**
     * 결제 처리
     * @param param
     * @return
     * @throws Exception
     */
    @PostMapping("/request")
    @Operation(summary = "결제 처리")
    public Payment requestPayment(@RequestBody Payment param) throws Exception {
        return new Payment().mockPayment(param);
    }
}
