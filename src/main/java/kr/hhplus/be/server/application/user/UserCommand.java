package kr.hhplus.be.server.application.user;

import lombok.Data;

import java.util.List;

@Data
public class UserCommand {
    private Long userId;
    private List<Long> couponIdList;
}
