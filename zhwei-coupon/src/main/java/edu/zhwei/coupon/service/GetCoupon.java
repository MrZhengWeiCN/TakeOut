package edu.zhwei.coupon.service;

import edu.zhwei.coupon.common.BookResult;

public interface GetCoupon {

	BookResult getCoupon(Integer couponId, Integer userId);
}
