package edu.zhwei.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Type {

	@RequestMapping("/manMenuTypePageEnter")
	public String type(){
		return "manager/man_menu_type";
	}
}
