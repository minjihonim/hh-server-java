package kr.hhplus.be.server.product.presentation.api;

import io.swagger.v3.oas.annotations.Operation;
import kr.hhplus.be.server.product.presentation.dto.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    /**
     * 상품 조회
     * @return
     * @throws Exception
     */
    @GetMapping("/list")
    @Operation(summary = "상품 조회")
    public List<Product> getProductList() throws Exception {
        return new Product().mockProductList();
    }

    /**
     * 상위 상품조회
     * @return
     * @throws Exception
     */
    @GetMapping("/popular/list")
    @Operation(summary = "인기 상품 조회")
    public List<Product> getPopularProductList() throws Exception {
        return new Product().mockPopularProductList();
    }
}
