package kr.hhplus.be.server.balance.presentation.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BalanceResponse {
    @Schema(description = "사용자 고유 아이디", example = "1")
    private Long userId;
    @Schema(description = "사용자 보유 금액", example = "1200")
    private Long balance;

    public BalanceResponse mockData(long id) {
        return new BalanceResponse(id, 10000L);
    }

    public BalanceResponse mockCharge(BalanceRequest req) {
        return new BalanceResponse(req.getUserId(), 10000L + req.getBalance());
    }
}
