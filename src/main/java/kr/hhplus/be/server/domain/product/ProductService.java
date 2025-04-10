package kr.hhplus.be.server.domain.product;

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
     * @param product
     */
    public Integer getProductCnt(Product product) {
        Integer checkCnt = productRepository.getProductCnt(product);
        if(checkCnt < 1) {
            throw new RuntimeException("물품이 존재하지 않습니다.");
        }
        return checkCnt;
    }
}
