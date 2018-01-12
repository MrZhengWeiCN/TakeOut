package edu.zhwei.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.zhwei.common.BookResult;
import edu.zhwei.common.JsonUtils;
import edu.zhwei.pojo.Order;
import edu.zhwei.pojo.Orderdetail;
import edu.zhwei.service.OrderService;

/**
 * 订单
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * github:
 * </p>
 * 
 * @date 2018-1-9 下午3:48:05
 * @author Zhwei
 */
@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	/**
	 * 订单列表
	 * 
	 * @return
	 */
	@RequestMapping("/orderListPageEnter/{orderUserName}")
	public String orderList(Model model,@PathVariable String orderUserName) {
		List<Order> orders = orderService.findAll(orderUserName);
		model.addAttribute("orders", orders);
		return "orderlist";
	}

	/**
	 * 展示订单详情，一个订单里面有很多菜品条目
	 * 
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/orderDetailPageEnter")
	public String detail(Integer orderId,Model model,HttpServletRequest request ) {
		List<Orderdetail> details = orderService.findDetailByOrderId(orderId);
		model.addAttribute("backURL", request.getRequestURL());
		model.addAttribute("details", details);
		return "orderdetail";
	}

	/**
	 * 订单创建
	 */
	@RequestMapping("/shoppingSubmit")
	public String orderCreate(Order order, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println("开始！");
		BookResult result = orderService.orderCreate(order, request, response);
		if (result.getStatus() != 200) {
			// 发送错误了
			model.addAttribute("errorInfo", result.getMsg());
			return "error";
		}
		String orderJson = (String) result.getData();
		Order jsonToPojo = JsonUtils.jsonToPojo(orderJson, Order.class);
		model.addAttribute("order", jsonToPojo);
		return "order_success";
	}
	
}
