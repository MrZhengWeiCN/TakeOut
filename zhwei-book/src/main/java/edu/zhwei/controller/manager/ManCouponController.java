package edu.zhwei.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zhwei.common.BookResult;
import edu.zhwei.pojo.Coupon;
import edu.zhwei.service.CouponService;

@Controller
public class ManCouponController {

	@Autowired
	private CouponService couponService;
	
	@RequestMapping("/manCouponPageEnter")
	public String manCoupon(Model model){
		List<Coupon> coupons = couponService.findAllForMan();
		model.addAttribute("coupons", coupons);
		return "manager/man_coupon_content";
	}
	
	@RequestMapping("/addProcess")
	public String addProcess(Coupon coupon,Model model){
		BookResult result = couponService.addCoupon(coupon);
		if(result.getStatus()==200){
			model.addAttribute("clickURL", "/manCouponPageEnter");
			model.addAttribute("click", "返回继续添加");
			return "success";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/manDeleteCoupon")
	@ResponseBody
	public BookResult manDeleteCoupon(Integer couponId){
		BookResult result = couponService.manDeleteCoupon(couponId);
		return result;
	}
	
	@RequestMapping("/userDeleteCoupon")
	@ResponseBody
	public BookResult userDeleteCoupon(Integer couponId,Integer userId){
		BookResult result = couponService.userDeleteCoupon(couponId,userId);
		return result;
	}
}
