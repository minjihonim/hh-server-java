package kr.hhplus.be.server.domain.product;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    public List<Product> getProductList() {
        List<Product> result = new ArrayList<>();
        return result;
    }

    public Integer getProductCnt(Product product) {
        return 1;
    }
}
