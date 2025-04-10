package kr.hhplus.be.server.domain.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import kr.hhplus.be.server.presentation.api.product.dto.ProductResponse;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Product {

    @Id
    private Long id;

    private String name;

    private Long price;

    private String desciption;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;

    public Product() {

    }

    public ProductResponse fromProduct(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        productResponse.setDesciption(product.getDesciption());
        return productResponse;
    }

    public Product(Long id, String name, Long price, String desciption) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.desciption = desciption;
    }
}
