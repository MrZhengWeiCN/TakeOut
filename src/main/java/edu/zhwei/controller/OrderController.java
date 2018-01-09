package edu.zhwei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 订单
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>github: </p>
 * @date 2018-1-9 下午3:48:05
 * @author Zhwei
 */
@Controller
public class OrderController {

	/**
	 * 订单列表
	 * @return
	 */
	@RequestMapping("/orderListPageEnter")
	public String orderPage(){
		return "orderlist";
	}
	
	/**
	 * 展示订单详情，一个订单里面有很多菜品条目
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/orderDetailPageEnter")
	public String detail(Integer orderId){
		return "orderdetail";
	}
}
