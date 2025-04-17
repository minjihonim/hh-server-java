package kr.hhplus.be.server.presentation.api.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {
    private long id;
    private String name;
    private long couponId;
}
