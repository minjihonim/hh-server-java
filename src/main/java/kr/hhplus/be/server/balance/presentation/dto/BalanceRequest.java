package kr.hhplus.be.server.balance.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BalanceRequest {

    @Schema(description = "사용자 고유 아이디", example = "1")
    private long userId;
    @Positive
    @Schema(description = "유저 충전 금액", example = "1000")
    private long balance;
}
