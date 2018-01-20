package edu.zhwei.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import edu.zhwei.common.BookResult;
import edu.zhwei.common.HttpClientUtil;
import edu.zhwei.common.JsonUtils;
import edu.zhwei.pojo.Coupon;
import edu.zhwei.pojo.User;
import edu.zhwei.pojo.UserCoupon;
import edu.zhwei.service.CouponService;

@Service
public class CouponImpl implements CouponService {

	@Override
	public List<Coupon> findAll() {
		String couponListJson = HttpClientUtil.doGet("http://localhost:8081/list");
		List<Coupon> coupons = JsonUtils.jsonToList(couponListJson, Coupon.class);
		return coupons;
	}

	@Override
	public BookResult getCoupon(Integer couponId,HttpServletRequest request) {
		//来到这一步拦截器已经保证用户登录了。
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){
			return BookResult.build(400, "请登录！");
		}
		Integer userId = user.getUserId();
		Map<String, String> param = new HashMap<>();
		param.put("couponId", couponId.toString());
		param.put("userId", userId.toString());
		String resultJson = HttpClientUtil.doGet("http://localhost:8081/getCoupon", param );
		BookResult result = JsonUtils.jsonToPojo(resultJson, BookResult.class);
		return result;
	}

	@Override
	public List<UserCoupon> myCoupon(Integer userId,Integer condition) {
		Map<String, String> param = new HashMap<>();
		if(condition!=null)
			param.put("condition", condition.toString());
		String coupons = HttpClientUtil.doGet("http://localhost:8081/mycoupon/"+userId,param);
		List<UserCoupon> coups = JsonUtils.jsonToList(coupons, UserCoupon.class);
		return coups;
	}

	@Override
	public BookResult deleteUserCop(Integer userId, Integer couponId) {
		//删除优惠券
		if(couponId!=null&&couponId!=0){
			Map<String, String> param = new HashMap<>();
			param.put("userId", userId.toString());
			param.put("couponId", couponId.toString());
			String resultJson = HttpClientUtil.doGet("http://localhost:8081/deleteUserCop",param);
			BookResult result = JsonUtils.jsonToPojo(resultJson, BookResult.class);
			return result;
		}
		return BookResult.ok();
	}

	@Override
	public List<Coupon> findAllForMan() {
		String couponListJson = HttpClientUtil.doGet("http://localhost:8081/copforman");
		List<Coupon> coupons = JsonUtils.jsonToList(couponListJson, Coupon.class);
		return coupons;
	}

	@Override
	public BookResult addCoupon(Coupon coupon) {
		String couponJson = JsonUtils.objectToJson(coupon);
		String resultJson = HttpClientUtil.doPostJson("http://localhost:8081/addProcess", couponJson);
		BookResult result = JsonUtils.jsonToPojo(resultJson, BookResult.class);
		return result;
	}

	@Override
	public BookResult manDeleteCoupon(Integer couponId) {
		String resultJson = HttpClientUtil.doPost("http://localhost:8081/manDeleteCoupon/"+couponId);
		BookResult result = JsonUtils.jsonToPojo(resultJson, BookResult.class);
		return result;
	}

	@Override
	public BookResult userDeleteCoupon(Integer couponId, Integer userId) {
		Map<String, String> param = new HashMap<>();
		param.put("couponId", couponId.toString());
		param.put("userId", userId.toString());
		String resultJson = HttpClientUtil.doPost("http://localhost:8081/userDeleteCoupon",param);
		BookResult result = JsonUtils.jsonToPojo(resultJson, BookResult.class);
		return result;
	}

}
