package kr.hhplus.be.server.domain.payment.type;

import lombok.Getter;

@Getter
public enum PaymentType {
    FINISH, WAIT, PROGRESS;

    private String message;

    PaymentType() {
    }
}
