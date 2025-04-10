package kr.hhplus.be.server.presentation.api.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductRequest {
    private long id;
    private String name;
    private long price;
    private int count;

    public List<ProductRequest> mockProductList() throws Exception {
        List<ProductRequest> result = new ArrayList<>();
        ProductRequest product = new ProductRequest(1, "안경", 10000L, 10);
        result.add(product);
        ProductRequest product2 = new ProductRequest(2, "모자", 15000L, 20);
        result.add(product2);
        return result;
    }

    public List<ProductRequest> mockPopularProductList() {
        List<ProductRequest> result = new ArrayList<>();
        ProductRequest product = new ProductRequest(1, "안경", 10000L, 10);
        result.add(product);
        ProductRequest product2 = new ProductRequest(2, "모자", 15000L, 20);
        result.add(product2);
        ProductRequest product3 = new ProductRequest(3, "장갑", 13000L, 0);
        result.add(product3);
        ProductRequest product4 = new ProductRequest(4, "바지", 15000L, 0);
        result.add(product4);
        ProductRequest product5 = new ProductRequest(5, "양말", 5000L, 0);
        result.add(product5);
        return result;
    }
}
