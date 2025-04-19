package kr.hhplus.be.server.domain.coupon.repository;

import kr.hhplus.be.server.domain.coupon.model.Coupon;

import java.util.List;

public interface CouponRepository {

    /**
     * 쿠폰 정보 조회
     * @param couponId
     * @return
     */
    Coupon getCouponInfo(Long couponId);

    /**
     * 쿠폰 정보 리스트 조회
     * @param varCouponIdList
     * @return
     */
    List<Coupon> getCouponInfoList(List<Long> varCouponIdList);
}
