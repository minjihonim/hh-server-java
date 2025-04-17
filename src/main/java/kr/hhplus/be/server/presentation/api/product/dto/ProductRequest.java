package kr.hhplus.be.server.presentation.api.product.dto;

import kr.hhplus.be.server.domain.product.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductRequest {
    private long id;
    private String name;
    private long price;
    private String desciption;
    private int quantity;

    public Product toProduct() {
        Product product = new Product(id, name, price, desciption);
        return product;
    }
}
