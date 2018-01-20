package edu.zhwei.coupon.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class UserCouponSendMessage {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send(String message) {
		// 这里会按xml中配置的convert方式转换对象
		amqpTemplate
				.convertAndSend("userCouponExchange", "userCouponQueue", message);
	}
}
