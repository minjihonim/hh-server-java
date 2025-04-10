package kr.hhplus.be.server.domain.coupon;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
public class CouponDetail {

    @Id
    private Long id;

    private String name;

    private int discount;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Integer maxQuantity;

    private Integer issuedQuantity;

    private LocalDate expirationDay;

    public CouponDetail mockData() {
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
