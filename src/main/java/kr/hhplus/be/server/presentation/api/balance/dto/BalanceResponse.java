package kr.hhplus.be.server.presentation.api.balance.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BalanceResponse {

    private String code;
    private String message;

    @Schema(description = "사용자 고유 아이디", example = "1")
    private Long userId;
    @Schema(description = "사용자 보유 금액", example = "1200")
    private Long balance;

    public BalanceResponse(Long id, long l) {
        this.userId = id;
        this.balance = l;
    }

    public BalanceResponse mockData(Long id) {
        return new BalanceResponse(id, 10000L);
    }

    public BalanceResponse mockCharge(BalanceRequest req) {
        return new BalanceResponse(req.getUserId(), 10000L + req.getAmount());
    }

}
