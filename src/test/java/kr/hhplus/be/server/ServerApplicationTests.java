package kr.hhplus.be.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.hhplus.be.server.presentation.api.balance.dto.BalanceRequest;
import kr.hhplus.be.server.presentation.api.order.dto.OrderRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
@WebMvcTest
class ServerApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("잔액충전 테스트")
    void 잔액_충전_mock_test() throws Exception {
        // given
        BalanceRequest req = new BalanceRequest(1L, 20000L);
        String jsonBody = objectMapper.writeValueAsString(req);
        // when
        mockMvc.perform(post("/api/balance/charge")
                .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
				.andExpect(status().isOk())
                .andExpect(jsonPath("$.balance").value(30000L));
    }

    @Test
    @DisplayName("잔액조회 테스트")
    void 잔액_조회_테스트() throws Exception {
        mockMvc.perform(get("/api/balance/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.balance").value(10000L));
    }

    @Test
    @DisplayName("선착순쿠폰 발급 테스트")
    void 쿠폰발급_테스트() throws Exception {
        mockMvc.perform(get("/api/coupon/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("홍길동"));
    }

    @Test
    @DisplayName("상품조회 테스트")
    void 상품조회_테스트() throws Exception {
        mockMvc.perform(get("/api/product/list")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    @DisplayName("상위 상품조회 테스트")
    void 상위_상품조회_테스트() throws Exception {
        mockMvc.perform(get("/api/product/popular/list")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(5));
    }

    @Test
    @DisplayName("주문 처리 테스트")
    void 주문_처리_테스트() throws Exception {
        // given
        OrderRequest paramOrder = new OrderRequest(1, new ArrayList<>(), 1, 30000L, 0, 0);
        String jsonBody = objectMapper.writeValueAsString(paramOrder);
        // when
        mockMvc.perform(post("/api/order/request")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(1));  // 주문처리 완료 상태값
    }

}
