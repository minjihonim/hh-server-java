package kr.hhplus.be.server.domain.coupon.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Coupon {

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

    public Coupon(Long id, String name, int discount, Integer maxQuantity, Integer issuedQuantity, LocalDate expirationDay) {
        this.id = id;
        this.name = name;
        this.discount = discount;
        this.maxQuantity = maxQuantity;
        this.issuedQuantity = issuedQuantity;
        this.expirationDay = expirationDay;
    }

    public Coupon mockData() {
        this.id = 1L;
        this.name = "할인쿠폰1";
        this.discount = 10;
        this.startTime = LocalDateTime.now();
        this.endTime = LocalDateTime.now().plusDays(1);
        this.maxQuantity = 10;
        this.issuedQuantity = 1;
        this.expirationDay = LocalDate.now().plusDays(3);
        return this;
    }

}
