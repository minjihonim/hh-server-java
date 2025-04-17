package kr.hhplus.be.server.domain.product;

import kr.hhplus.be.server.domain.product.model.Product;
import kr.hhplus.be.server.domain.product.model.ProductOption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProductList() {
        return productRepository.getProductList();
    }

    /**
     * 상품 데이터 확인
     * @param productOption
     */
    public Integer getProductCnt(ProductOption productOption) {
        Integer checkCnt = productRepository.getProductCnt(productOption);
        if(checkCnt < 1) {
            return 0;
        }
        return checkCnt;
    }
}
