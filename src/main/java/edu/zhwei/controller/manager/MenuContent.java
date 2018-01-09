package edu.zhwei.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuContent {

	@RequestMapping("/manMenuPageEnter")
	public String manuPage(){
		return "manager/man_menu";
	}
}
