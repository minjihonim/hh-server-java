package kr.hhplus.be.server.presentation.api.balance.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import kr.hhplus.be.server.application.balance.BalanceCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BalanceRequest {

    @Schema(description = "사용자 고유 아이디", example = "1")
    private Long userId;
    @Positive
    @Schema(description = "유저 충전 금액", example = "1000")
    private Long amount;

    public BalanceCommand toCommand() throws Exception {
        BalanceCommand command = new BalanceCommand();
        command.setUserId(this.userId);
        command.setAmount(this.amount);
        return command;
    }
}
