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
import org.springframework.web.bind.annotation.RequestParam;

import edu.zhwei.common.BookResult;
import edu.zhwei.common.JsonUtils;
import edu.zhwei.common.PageOpt;
import edu.zhwei.pojo.Order;
import edu.zhwei.pojo.Orderdetail;
import edu.zhwei.pojo.User;
import edu.zhwei.service.CouponService;
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
	@Autowired
	private CouponService couponService;

	/**
	 * 订单列表
	 * 
	 * @return
	 */
	@RequestMapping("/orderListPageEnter/{orderUserName}")
	public String orderList(Model model, @PathVariable String orderUserName,
			@RequestParam(value = "page", defaultValue = "1") Integer page) {
		List<Order> orders = orderService.findAll(orderUserName);
		int endPage = PageOpt.pageRecord(orders, PageOpt.SHOP);
		orders = PageOpt.pageList(orders, page, PageOpt.ORDER_LIST);
		
		model.addAttribute("endPage", endPage);
		model.addAttribute("startPage", 1);
		model.addAttribute("currPage", page);
		model.addAttribute("orders", orders);
		return "orderlist";
	}

	/**
	 * 展示订单详情，一个订单里面有很多菜品条目
	 * 
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/orderDetailPageEnter/{orderId}")
	public String detail(@PathVariable Integer orderId, Model model,
			HttpServletRequest request) {
		List<Orderdetail> details = orderService.findDetailByOrderId(orderId);
		model.addAttribute("backURL", request.getRequestURL());
		model.addAttribute("details", details);
		
		model.addAttribute("endPage", 1);
		model.addAttribute("startPage", 1);
		model.addAttribute("currPage", 1);
		return "orderdetail";
	}

	/**
	 * 订单创建
	 */
	@RequestMapping("/shoppingSubmit")
	public String orderCreate(Order order, Model model,Integer couponId,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println("开始！");
		User user = (User) request.getSession().getAttribute("user");
		order.setOrderUserName(user.getUserName());
		//如果使用了优惠券则删除优惠券
		BookResult result = orderService.orderCreate(order, request, response,user.getUserId(),couponId);
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
