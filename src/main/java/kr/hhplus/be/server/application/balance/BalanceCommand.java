package kr.hhplus.be.server.application.balance;

import lombok.Data;

@Data
public class BalanceCommand {

    private long userId;

    private long amount;

}
