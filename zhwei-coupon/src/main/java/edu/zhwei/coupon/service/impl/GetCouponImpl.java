package edu.zhwei.coupon.service.impl;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zhwei.coupon.common.BookResult;
import edu.zhwei.coupon.common.JsonUtils;
import edu.zhwei.coupon.component.JedisClient;
import edu.zhwei.coupon.component.SendMessage;
import edu.zhwei.coupon.component.UserCouponSendMessage;
import edu.zhwei.coupon.mapper.CouponMapper;
import edu.zhwei.coupon.mapper.UserCouponMapper;
import edu.zhwei.coupon.pojo.Coupon;
import edu.zhwei.coupon.pojo.UserCoupon;
import edu.zhwei.coupon.pojo.UserCouponExample;
import edu.zhwei.coupon.service.CouponService;
import edu.zhwei.coupon.service.GetCoupon;

@Service
public class GetCouponImpl implements GetCoupon {

	@Autowired
	private JedisClient jedisClient;
	@Autowired
	private CouponMapper couponMapper;
	@Autowired
	private UserCouponMapper userCouponMapper;
	
	@Autowired 
	private SendMessage sendMessage;
	@Autowired
	private UserCouponSendMessage userCouponSendMessage;
	
	@Override
	public BookResult getCoupon(Integer couponId, Integer userId) {

		
		UserCouponExample example = new UserCouponExample();
		edu.zhwei.coupon.pojo.UserCouponExample.Criteria criteria = example
				.createCriteria();
		criteria.andCouponIdEqualTo(couponId);
		criteria.andUserIdEqualTo(userId);
		List<UserCoupon> userCoupons = userCouponMapper
				.selectByExample(example);
		if (userCoupons != null && userCoupons.size() > 0) {
			return BookResult.build(400, "优惠券以领取，请勿重复领取！");
		}
		// 来到此方法之前使用拦截器确保了用户登陆了
		Coupon coupon = couponMapper.selectByPrimaryKey(couponId);
		if(new Date().getTime()<coupon.getCouponKilltime().getTime()){
			return BookResult.build(400, "抢购未开始，请勿作弊！");
		}
		UserCoupon userCoupon = new UserCoupon();

		// 第一个进入的需要把发放的优惠券数量记录下来
		// 下面的做法是错误的，是线程不安全的，会导致重复执行setset("CouponNum:"+couponId,vale)
		// 正确的做法是管理员在提交优惠券时就设置redis键值。
		/* String num = jedisClient.get("CouponNum:"+couponId); */
		/*
		 * Coupon coupon = couponMapper.selectByPrimaryKey(couponId);
		 * if(num==null){ jedisClient.set("CouponNum:"+couponId,
		 * coupon.getCouponNum().toString()); }
		 */
		// decr是线程安全的
		Long num = jedisClient.decr("CouponNum:" + couponId);
		if (num < 0) {
			return BookResult.build(400, "优惠券已被抢完");
		}
		// 进行关联
		userCoupon.setUserId(userId);
		userCoupon.setCouponId(couponId);
		/*
		 * 3.name 4.说明 5.开始时间 6.结束时间 7.优惠最低额度 8.减免多少 9.状态（0表示还未使用，1表示已经使用）
		 */
		userCoupon.setCouponName(coupon.getCouponName());
		userCoupon.setCouponDesc(coupon.getCouponDesc());
		userCoupon.setCouponStartTime(coupon.getCouponStartTime());
		userCoupon.setCouponEndTime(coupon.getCouponEndTime());
		userCoupon.setCouponThreshold(coupon.getCouponThreshold());
		userCoupon.setCouponDiscount(coupon.getCouponDiscount());
		userCoupon.setCouponStatus(0);
		try {
			// 减库存这一步应该给rabbitmq处理
			/*coupon.setCouponNum(coupon.getCouponNum() - 1);
			couponMapper.updateByPrimaryKeySelective(coupon);*/
			sendMessage.send(coupon.getCouponId().toString());
			
			String userCouponJson = JsonUtils.objectToJson(userCoupon);
			userCouponJson = URLEncoder.encode(userCouponJson, "utf-8");
			userCouponSendMessage.send(userCouponJson);
			
			/*userCouponMapper.insert(userCoupon);*/
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400, "未知错误发生！请联系技术人员");
		}
	}

}
