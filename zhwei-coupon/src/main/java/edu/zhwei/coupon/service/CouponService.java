package edu.zhwei.coupon.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.zhwei.coupon.common.BookResult;
import edu.zhwei.coupon.pojo.Coupon;
import edu.zhwei.coupon.pojo.UserCoupon;

public interface CouponService {

	BookResult addCoupon(Coupon coupon);

	List<Coupon> findAll();

	List<Coupon> findAllForMan();

	BookResult getCoupon(Integer couponId, Integer userId);

	List<UserCoupon> getPersonalCopList(Integer userId,Integer condition);

	BookResult deleteUserCop(Integer userId, Integer couponId);

	BookResult manDeleteCoupon(Integer couponId);
	
	BookResult userDeleteCoupon(Integer couponId,Integer userId);
}
