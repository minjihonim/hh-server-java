package kr.hhplus.be.server.unit;

import kr.hhplus.be.server.domain.product.Product;
import kr.hhplus.be.server.domain.product.ProductRepository;
import kr.hhplus.be.server.domain.product.ProductService;
import kr.hhplus.be.server.presentation.api.product.dto.ProductResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductUnitTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    @DisplayName("상품 조회 테스트")
    public void productListTest() {
        // given
        List<Product> productList = new ArrayList<>();
        Product product = new Product(1L, "가방", 20000L, "빨간색가방");
        productList.add(product);

        // when
        when(productRepository.getProductList()).thenReturn(productList);
        List<Product> result = productService.getProductList();

        // then
        assertThat(result).isEqualTo(productList);
        assertThat(result.size()).isEqualTo(1);
    }
}
