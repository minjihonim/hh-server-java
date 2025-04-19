package kr.hhplus.be.server.infrastructure.user.jpa;

import kr.hhplus.be.server.infrastructure.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
}
