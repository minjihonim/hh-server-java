package kr.hhplus.be.server.balance.presentation.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BalanceResponse {
    private Long userId;

    private Long balance;

    public BalanceResponse mockData(long id) {
        return new BalanceResponse(id, 10000L);
    }

    public BalanceResponse mockCharge(BalanceRequest req) {
        return new BalanceResponse(req.getUserId(), 10000L + req.getBalance());
    }
}
