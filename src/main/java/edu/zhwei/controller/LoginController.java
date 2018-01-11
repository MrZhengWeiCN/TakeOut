package edu.zhwei.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.zhwei.common.BookResult;
import edu.zhwei.service.LogRegService;

@Controller
public class LoginController {

	@Autowired
	private LogRegService logRegService;

	@RequestMapping("/loginPageEnter")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/loginProcess")
	public String loginProcess(String userName, String userPasswd, Model model,
			HttpServletRequest request) {
		BookResult result = logRegService.loginProcess(userName, userPasswd,
				request);
		if (result.getStatus() == 400) {
			model.addAttribute("logError", result.getMsg());
			return "login";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping("/logoutProcess")
	public String logoutProcess(Model model, HttpServletRequest request) {
		BookResult result = logRegService.logoutProcess(request);
		if(result.getStatus()==200){
			model.addAttribute("sucInfo","已安全退出，期待您的下一次光临" );
			model.addAttribute("click", "返回首页");
			model.addAttribute("clickURL", "/");
			return "success";
		}
		return "error";
	}
}
