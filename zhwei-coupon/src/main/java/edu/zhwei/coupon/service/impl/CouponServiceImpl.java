package edu.zhwei.coupon.service.impl;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zhwei.coupon.common.BookResult;
import edu.zhwei.coupon.common.CookieUtils;
import edu.zhwei.coupon.component.JedisClient;
import edu.zhwei.coupon.mapper.CouponMapper;
import edu.zhwei.coupon.mapper.UserCouponMapper;
import edu.zhwei.coupon.pojo.Coupon;
import edu.zhwei.coupon.pojo.CouponExample;
import edu.zhwei.coupon.pojo.UserCoupon;
import edu.zhwei.coupon.pojo.CouponExample.Criteria;
import edu.zhwei.coupon.pojo.User;
import edu.zhwei.coupon.pojo.UserCouponExample;
import edu.zhwei.coupon.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponMapper couponMapper;
	@Autowired
	private UserCouponMapper userCouponMapper;
	@Autowired
	private JedisClient jedisClient;
	
	@Override
	public BookResult addCoupon(Coupon coupon) {
		try {
			couponMapper.insert(coupon);
			jedisClient.set("CouponNum:"+coupon.getCouponId(), coupon.getCouponNum().toString());
			Long time = (coupon.getCouponKilltime().getTime()-System.currentTimeMillis())/1000;
			//开始上架后的一个礼拜失效
			jedisClient.expire("CouponNum:"+coupon.getCouponId(), (int) (time+7*24*3600));
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400, "未知错误发生！请联系技术人员");
		}
	}

	//优惠券首页的展示
	@Override
	public List<Coupon> findAll() {
		CouponExample example = new CouponExample();
		Criteria criteria = example.createCriteria();
		//条件：未过期，还有存货
		criteria.andCouponEndTimeGreaterThan(new Date());
		criteria.andCouponNumGreaterThanOrEqualTo(1);
		List<Coupon> coupons = couponMapper.selectByExample(example);
		return coupons;
	}
	
	@Override
	public BookResult getCoupon(Integer couponId, Integer userId) {
		// 确保没有重复领取
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
		UserCoupon userCoupon = new UserCoupon();
		if (coupon.getCouponNum() < 1) {
			//不能这样简单的计算库存
			//应该使用redis的单线程计算已经处理的订单
			return BookResult.build(400, "很遗憾，优惠券已领完！");
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
			//减库存这一步应该给rabbitmq处理
			coupon.setCouponNum(coupon.getCouponNum()-1);
			couponMapper.updateByPrimaryKeySelective(coupon);
			
			userCouponMapper.insert(userCoupon);
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400, "未知错误发生！请联系技术人员");
		}
	}

	// 找到所有的还是可用的？
	@Override
	public List<UserCoupon> getPersonalCopList(Integer userId, Integer condition) {
		List<UserCoupon> coupons;
		UserCouponExample example = new UserCouponExample();
		edu.zhwei.coupon.pojo.UserCouponExample.Criteria criteria = example
				.createCriteria();
		criteria.andUserIdEqualTo(userId);
		if (condition != null && condition == 1) {
			// 找到可用的
			criteria.andCouponStatusEqualTo(0);
			coupons = userCouponMapper.selectByExample(example);
		} else {
			// 找到所有的
			coupons = userCouponMapper.selectByExample(example);
		}
		return coupons;
	}

	//用过使用优惠券，别搞错了
	@Override
	public BookResult deleteUserCop(Integer userId, Integer couponId) {
		UserCouponExample example = new UserCouponExample();
		edu.zhwei.coupon.pojo.UserCouponExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andCouponIdEqualTo(couponId);
		try {
			List<UserCoupon> coupon = userCouponMapper.selectByExample(example );
			for (UserCoupon userCoupon : coupon) {
				userCoupon.setCouponStatus(1);
				userCouponMapper.updateByPrimaryKeySelective(userCoupon);
			}
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400, e.getMessage());
		}
	}

	//找到所有的优惠券
	@Override
	public List<Coupon> findAllForMan() {
		CouponExample example = new CouponExample();
		List<Coupon> coupons = couponMapper.selectByExample(example );
		return coupons;
	}

	
	
	@Override
	public BookResult manDeleteCoupon(Integer couponId) {
		try {
			jedisClient.del("CouponNum:"+couponId);
			couponMapper.deleteByPrimaryKey(couponId);
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400,"未知错误发生，联系技术人员！");
		}
	}

	//用户删除优惠券
	@Override
	public BookResult userDeleteCoupon(Integer couponId, Integer userId) {
		UserCouponExample example = new UserCouponExample();
		edu.zhwei.coupon.pojo.UserCouponExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andCouponIdEqualTo(couponId);
		try {
			userCouponMapper.deleteByExample(example );
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400,"未知错误发生，联系技术人员！");
		}
	} 

}
