package edu.zhwei.coupon.component;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zhwei.coupon.mapper.CouponMapper;
import edu.zhwei.coupon.pojo.Coupon;

public class Listener implements MessageListener {

	@Autowired
	private CouponMapper couponMapper;
	
	@Override
	public void onMessage(Message message) {
		String couponId = new String(message.getBody());
		Integer id = Integer.valueOf(couponId);
		Coupon coupon = couponMapper.selectByPrimaryKey(id);
		coupon.setCouponNum(coupon.getCouponNum()-1);
		couponMapper.updateByPrimaryKey(coupon);
		System.out.println("编号为"+id+"的优惠券库存减1");
	}

}
