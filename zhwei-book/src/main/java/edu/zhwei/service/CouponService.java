package edu.zhwei.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import edu.zhwei.common.BookResult;
import edu.zhwei.pojo.Coupon;
import edu.zhwei.pojo.UserCoupon;

public interface CouponService {

	List<Coupon> findAll();

	BookResult getCoupon(Integer couponId,HttpServletRequest request);

	List<UserCoupon> myCoupon(Integer userId,Integer condition);

	BookResult deleteUserCop(Integer userId, Integer couponId);
	
	List<Coupon> findAllForMan();

	BookResult addCoupon(Coupon coupon);

	BookResult manDeleteCoupon(Integer couponId);

	BookResult userDeleteCoupon(Integer couponId, Integer userId);
}
