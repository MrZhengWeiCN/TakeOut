package edu.zhwei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.zhwei.common.BookResult;
import edu.zhwei.pojo.User;
import edu.zhwei.service.LogRegService;

@Controller
public class RegisterController {

	@Autowired
	private LogRegService logRegService;

	@RequestMapping("/regPageEnter")
	public String regPage() {
		return "reg";
	}

	@RequestMapping("/regProcess")
	public String regProcess(User user, Model model) {
		BookResult result = logRegService.validateReg(user);
		if (result.getStatus() == 400) {
			model.addAttribute("registerError", result.getMsg());
			return "reg";
		} else {
			model.addAttribute("sucInfo", "恭喜您：" + user.getUserName()
					+ ",注册成功！");
			model.addAttribute("click", "立即登陆");
			model.addAttribute("clickURL", "/loginPageEnter");
			return "success";
		}
	}
}
