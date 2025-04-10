package kr.hhplus.be.server.presentation.api.balance;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kr.hhplus.be.server.application.balance.BalanceCommand;
import kr.hhplus.be.server.application.balance.BalanceFacade;
import kr.hhplus.be.server.domain.balance.Balance;
import kr.hhplus.be.server.domain.balance.BalanceService;
import kr.hhplus.be.server.presentation.api.balance.dto.BalanceRequest;
import kr.hhplus.be.server.presentation.api.balance.dto.BalanceResponse;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/balance")
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceFacade balanceFacade;
    private final BalanceService balanceService;

    /**
     * 잔액 조회
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "사용자 잔액 조회")
    public BalanceResponse getPoint(@PathVariable("id") Long id) {
        Balance balance = balanceService.getPoint(id);
        BalanceResponse response = balance.fromBalance(balance);
        return response;
    }

    /**
     * 잔액 충전
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/charge")
    @Operation(summary = "사용자 잔액 충전")
    public BalanceResponse charge(@Valid @RequestBody BalanceRequest request) throws Exception {
        // 충전 진행
        BalanceCommand command = request.toCommand();
        balanceFacade.charge(command);
        // 결과
        BalanceResponse response = new BalanceResponse();
        response.setCode("0000");
        response.setMessage("충전성공");
        return response;
    }


}
