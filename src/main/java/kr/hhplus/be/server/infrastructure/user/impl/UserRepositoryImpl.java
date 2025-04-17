package kr.hhplus.be.server.infrastructure.user.impl;

import kr.hhplus.be.server.domain.user.model.User;
import kr.hhplus.be.server.domain.user.repository.UserRepository;
import kr.hhplus.be.server.infrastructure.user.jpa.UserJpaRepository;
import kr.hhplus.be.server.infrastructure.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User getUserInfo(Long userId) {
        UserEntity userInfo = userJpaRepository.findById(userId).orElse(null);
        if (userInfo == null) {
            return null;
        }
        return new User(userInfo.getId(), userInfo.getName());
    }

}
