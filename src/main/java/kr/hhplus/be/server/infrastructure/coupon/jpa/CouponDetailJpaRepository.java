package kr.hhplus.be.server.infrastructure.coupon.jpa;

import kr.hhplus.be.server.infrastructure.coupon.model.IssuedCouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponDetailJpaRepository extends JpaRepository<IssuedCouponEntity, Long> {
    List<IssuedCouponEntity> findByUserId(Long userId);
}
