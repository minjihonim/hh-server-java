package kr.hhplus.be.server.domain.order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @Id
    private Long id;

    private Long orderId;

    private Long productOptionId;

    private int quantity;

    private Long amount;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;
}
