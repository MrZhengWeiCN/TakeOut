package edu.zhwei.controller.manager;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.zhwei.common.PageOpt;
import edu.zhwei.pojo.User;
import edu.zhwei.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/manUserPageEnter")
	public String userPage(Model model,@RequestParam(value = "page", defaultValue = "1") Integer page){
		List<User> users = userService.findAll();
		
		Collections.reverse(users);
		int endPage = PageOpt.pageRecord(users, 7);
		users = PageOpt.pageList(users, page, 7);
		model.addAttribute("endPage", endPage);
		model.addAttribute("startPage", 1);
		model.addAttribute("currPage", page);
		
		model.addAttribute("users", users);
		return "manager/man_user";
	}
	
	
}
