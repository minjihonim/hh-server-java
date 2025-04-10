package kr.hhplus.be.server.presentation.api.product;

import io.swagger.v3.oas.annotations.Operation;
import kr.hhplus.be.server.domain.product.Product;
import kr.hhplus.be.server.domain.product.ProductService;
import kr.hhplus.be.server.presentation.api.product.dto.ProductRequest;
import kr.hhplus.be.server.presentation.api.product.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * 상품 조회
     * @return
     * @throws Exception
     */
    @GetMapping("/list")
    @Operation(summary = "상품 조회")
    public List<ProductResponse> getProductList() throws Exception {
        List<Product> result = productService. getProductList();
        List<ProductResponse> responses = new ArrayList<>();
        for (Product product : result) {
            ProductResponse productResponse = product.fromProduct(product);
            responses.add(productResponse);
        }
        return responses;
    }

    /**
     * 상위 상품조회
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/popular/list")
    @Operation(summary = "인기 상품 조회")
    public List<ProductRequest> getPopularProductList() throws Exception {
        return new ProductRequest().mockPopularProductList();
    }
}
