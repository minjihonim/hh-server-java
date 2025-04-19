package kr.hhplus.be.server.infrastructure.coupon.jpa;

import kr.hhplus.be.server.infrastructure.coupon.model.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponJpaRepository extends JpaRepository<CouponEntity, Long> {
}
