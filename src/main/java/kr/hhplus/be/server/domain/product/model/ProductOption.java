package kr.hhplus.be.server.domain.product.model;

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
public class ProductOption {

    @Id
    private Long id;

    private Long productId;

    private String name;

    private int quantity;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;
}
