package kr.hhplus.be.server.balance.presentation.api;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kr.hhplus.be.server.balance.presentation.dto.BalanceRequest;
import kr.hhplus.be.server.balance.presentation.dto.BalanceResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/balance")
public class BalanceController {

    /**
     * 잔액 조회
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "사용자 잔액 조회")
    public BalanceResponse getPoint(@PathVariable("id") long id) {
        return new BalanceResponse().mockData(id);
    }

    /**
     * 잔액 충전
     * @param param
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/charge")
    @Operation(summary = "사용자 잔액 충전")
    public BalanceResponse charge(@Valid @RequestBody BalanceRequest param) throws Exception {
        return new BalanceResponse().mockCharge(param);
    }


}
