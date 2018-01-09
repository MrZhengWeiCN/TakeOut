package edu.zhwei.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/manUserPageEnter")
	public String userPage(){
		return "manager/man_user";
	}
}
