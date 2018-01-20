package edu.zhwei.coupon.component;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zhwei.coupon.common.JsonUtils;
import edu.zhwei.coupon.mapper.UserCouponMapper;
import edu.zhwei.coupon.pojo.UserCoupon;

public class UserCouponListener implements MessageListener {

	@Autowired
	private UserCouponMapper userCouponMapper;
	
	@Override
	public void onMessage(Message message) {
		try {
			String json = new String(message.getBody());
			json = URLDecoder.decode(json, "UTF-8");
			UserCoupon userCoupon = JsonUtils.jsonToPojo(json, UserCoupon.class);
			userCouponMapper.insert(userCoupon);
			System.out.println("成功插入userCoupon表");
		} catch (UnsupportedEncodingException e) {
			System.out.println("格式不支持");
		}
	}

}
