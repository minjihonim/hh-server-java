package kr.hhplus.be.server.balance.presentation.dto;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BalanceRequest {
    private long userId;
    @Positive
    private long balance;
}
