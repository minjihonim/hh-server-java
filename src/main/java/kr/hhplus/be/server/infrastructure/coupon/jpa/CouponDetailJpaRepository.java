package kr.hhplus.be.server.infrastructure.coupon.jpa;

import kr.hhplus.be.server.infrastructure.coupon.model.IssuedCouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponDetailJpaRepository extends JpaRepository<IssuedCouponEntity, Long> {
}
