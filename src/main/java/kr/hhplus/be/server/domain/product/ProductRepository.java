package kr.hhplus.be.server.domain.product;

import kr.hhplus.be.server.domain.product.model.Product;
import kr.hhplus.be.server.domain.product.model.ProductOption;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    public List<Product> getProductList() {
        List<Product> result = new ArrayList<>();
        return result;
    }

    public Integer getProductCnt(ProductOption productOption) {
        return 1;
    }
}
