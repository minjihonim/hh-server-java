package kr.hhplus.be.server.product.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product {
    private long id;
    private String name;
    private long price;
    private int count;

    public List<Product> mockProductList() throws Exception {
        List<Product> result = new ArrayList<>();
        Product product = new Product(1, "안경", 10000L, 10);
        result.add(product);
        Product product2 = new Product(2, "모자", 15000L, 20);
        result.add(product2);
        return result;
    }

    public List<Product> mockPopularProductList() {
        List<Product> result = new ArrayList<>();
        Product product = new Product(1, "안경", 10000L, 10);
        result.add(product);
        Product product2 = new Product(2, "모자", 15000L, 20);
        result.add(product2);
        Product product3 = new Product(3, "장갑", 13000L, 0);
        result.add(product3);
        Product product4 = new Product(4, "바지", 15000L, 0);
        result.add(product4);
        Product product5 = new Product(5, "양말", 5000L, 0);
        result.add(product5);
        return result;
    }
}
