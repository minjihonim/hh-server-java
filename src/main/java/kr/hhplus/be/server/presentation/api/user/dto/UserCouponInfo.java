package kr.hhplus.be.server.presentation.api.user.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserCouponInfo {
    private Long id;

    private String name;

    private int discount;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Integer maxQuantity;

    private Integer issuedQuantity;

    private LocalDate expirationDay;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;
}
