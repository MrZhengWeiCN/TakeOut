package edu.zhwei.controller.manager;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zhwei.common.BookResult;
import edu.zhwei.common.PageOpt;
import edu.zhwei.pojo.Order;
import edu.zhwei.pojo.Orderdetail;
import edu.zhwei.service.OrderService;

@Controller
public class OrderOpt {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/manOrderPageEnter")
	public String orderPage(Model model,@RequestParam(value = "page", defaultValue = "1") Integer page){
		List<Order> orders = orderService.findAll();
		
		Collections.reverse(orders);
		int endPage = PageOpt.pageRecord(orders, 7);
		orders = PageOpt.pageList(orders, page, 7);
		model.addAttribute("endPage", endPage);
		model.addAttribute("startPage", 1);
		model.addAttribute("currPage", page);
		
		model.addAttribute("orders", orders);
		return "manager/man_order";
	}
	
	@RequestMapping("/manOrderDetailPageEnter")
	public String detailPage(Integer orderId,Model model){
		List<Orderdetail> OrderDetails = orderService.findDetailByOrderId(orderId);
		model.addAttribute("OrderDetails", OrderDetails);
		return "manager/man_orderdetail";
	}
	
	@RequestMapping("/manOrderChange")
	@ResponseBody
	public BookResult orderChange(String opt,Integer id){
		BookResult result = orderService.orderChange(opt,id);
		return result;
	}
}
