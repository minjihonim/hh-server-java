package kr.hhplus.be.server.domain.user.repository;

import kr.hhplus.be.server.domain.user.model.User;

public interface UserRepository {

    User getUserInfo(Long userId);
}
