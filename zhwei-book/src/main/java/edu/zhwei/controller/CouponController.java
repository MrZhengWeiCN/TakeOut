package edu.zhwei.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zhwei.common.BookResult;
import edu.zhwei.common.PageOpt;
import edu.zhwei.pojo.Coupon;
import edu.zhwei.pojo.UserCoupon;
import edu.zhwei.service.CouponService;

@Controller
public class CouponController {

	@Autowired
	private CouponService couponService;

	@RequestMapping("/coupon")
	public String couponList(Model model,
			@RequestParam(value = "page", defaultValue = "1") Integer page) {
		List<Coupon> coupons = couponService.findAll();

		int endPage = PageOpt.pageRecord(coupons, 10);
		coupons = PageOpt.pageList(coupons, page, 10);
		model.addAttribute("endPage", endPage);
		model.addAttribute("startPage", 1);
		model.addAttribute("currPage", page);
		model.addAttribute("destPage", "/coupon");

		model.addAttribute("coupons", coupons);

		return "coupon/list";
	}

	@RequestMapping("/getCoupon")
	@ResponseBody
	public BookResult getCoupon(Integer couponId, HttpServletRequest request) {
		BookResult result = couponService.getCoupon(couponId, request);
		return result;
	}

	// 需要被拦截，验证用户是否登陆
	@RequestMapping("/mycoupon/{userId}")
	public String mycoupon(@PathVariable Integer userId, Integer condition,
			Model model,
			@RequestParam(value = "page", defaultValue = "1") Integer page) {
		List<UserCoupon> coupons = couponService.myCoupon(userId, condition);

		int endPage = PageOpt.pageRecord(coupons, 10);
		coupons = PageOpt.pageList(coupons, page, 10);

		model.addAttribute("endPage", endPage);
		model.addAttribute("startPage", 1);
		model.addAttribute("currPage", page);

		model.addAttribute("destPage", "/mycoupon/"+userId);
		model.addAttribute("coupons", coupons);
		return "coupon/mycoupons";
	}
}
