package kr.hhplus.be.server.infrastructure.coupon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "coupon")
@Getter
@NoArgsConstructor
public class CouponEntity {

    @Id
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
