package edu.zhwei.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zhwei.common.BookResult;
import edu.zhwei.pojo.Coupon;
import edu.zhwei.pojo.UserCoupon;
import edu.zhwei.service.CouponService;

@Controller
public class CouponController {

	@Autowired
	private CouponService couponService;
	
	@RequestMapping("/coupon")
	public String couponList(Model model){
		List<Coupon> coupons = couponService.findAll();
		model.addAttribute("coupons", coupons);
		return "coupon/list";
	}
	
	@RequestMapping("/getCoupon")
	@ResponseBody
	public BookResult getCoupon(Integer couponId,HttpServletRequest request){
		BookResult result = couponService.getCoupon(couponId,request);
		return result;
	}
	
	//需要被拦截，验证用户是否登陆
	@RequestMapping("/mycoupon/{userId}")
	public String mycoupon(@PathVariable Integer userId,Integer condition,Model model){
		List<UserCoupon> coupons = couponService.myCoupon(userId,condition);
		model.addAttribute("coupons", coupons);
		return "coupon/mycoupons";
	}
}
