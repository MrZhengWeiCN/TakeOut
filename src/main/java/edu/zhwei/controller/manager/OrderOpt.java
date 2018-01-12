package edu.zhwei.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.zhwei.pojo.Order;
import edu.zhwei.service.OrderService;

@Controller
public class OrderOpt {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/manOrderPageEnter")
	public String orderPage(Model model){
		List<Order> orders = orderService.findAll();
		model.addAttribute("orders", orders);
		return "manager/man_order";
	}
	
	@RequestMapping("/manOrderDetailPageEnter")
	public String detailPage(){
		return "manager/man_orderdetail";
	}
}
