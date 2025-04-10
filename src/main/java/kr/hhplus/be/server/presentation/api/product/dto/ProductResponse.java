package kr.hhplus.be.server.presentation.api.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private Long id;

    private String name;

    private Long price;

    private String desciption;
}
