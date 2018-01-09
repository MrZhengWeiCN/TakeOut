package edu.zhwei.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderOpt {

	@RequestMapping("/manOrderPageEnter")
	public String orderPage(){
		return "manager/man_order";
	}
	
	@RequestMapping("/manOrderDetailPageEnter")
	public String detailPage(){
		return "manager/man_orderdetail";
	}
}
