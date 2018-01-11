package edu.zhwei.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.zhwei.pojo.User;
import edu.zhwei.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/manUserPageEnter")
	public String userPage(Model model){
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "manager/man_user";
	}
	
	
}
