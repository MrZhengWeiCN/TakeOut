package edu.zhwei.coupon.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zhwei.coupon.common.BookResult;
import edu.zhwei.coupon.pojo.Coupon;
import edu.zhwei.coupon.pojo.UserCoupon;
import edu.zhwei.coupon.service.CouponService;
import edu.zhwei.coupon.service.GetCoupon;

/**
 * 只是发布服务，供前台调用。
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>github: </p>
 * @date 2018-1-18 上午11:45:51
 * @author Zhwei
 */
@Controller
public class CouponController {


	@Autowired
	private CouponService couponService;
	@Autowired
	private GetCoupon getCoupon;
	
	@RequestMapping("/addPage")
	public String addPage(){
		return "add";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public List<Coupon> listPage(Model model){
		List<Coupon> coupons = couponService.findAll();
		return coupons;
	}
	
	@RequestMapping("/addProcess")
	@ResponseBody
	public BookResult addCoupon(@RequestBody Coupon coupon){
		BookResult result = couponService.addCoupon(coupon);
		return result;
	}
	
	//用户获得优惠券
	@RequestMapping("/getCoupon")
	@ResponseBody
	public BookResult getCoupon(Integer couponId,Integer userId){
		BookResult result = getCoupon.getCoupon(couponId,userId);
		return result;
	}
	
	@RequestMapping("/mycoupon/{userId}")
	@ResponseBody
	public List<UserCoupon> myCoupon(@PathVariable Integer userId,Integer condition){
		List<UserCoupon> coupons = couponService.getPersonalCopList(userId,condition);
		return coupons;
	}
	
	@RequestMapping("/deleteUserCop")
	@ResponseBody
	public BookResult deleteUserCop(Integer userId,Integer couponId){
		BookResult result = couponService.deleteUserCop(userId,couponId);
		return result;
	}
	
	@RequestMapping("/copforman")
	@ResponseBody
	public List<Coupon> copforman(){
		List<Coupon> coupons = couponService.findAllForMan();
		return coupons;
	}
	
	@RequestMapping("/manDeleteCoupon/{couponId}")
	@ResponseBody
	public BookResult manDeleteCoupon(@PathVariable Integer couponId){
		BookResult result = couponService.manDeleteCoupon(couponId);
		return result;
	}
	
	@RequestMapping("/userDeleteCoupon")
	@ResponseBody
	public BookResult userDeleteCoupon(Integer userId,Integer couponId){
		BookResult result = couponService.userDeleteCoupon(couponId, userId);
		return result;
	}
}
