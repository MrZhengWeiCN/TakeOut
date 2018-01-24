package edu.zhwei.controller;

import java.awt.print.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zhwei.common.BookResult;
import edu.zhwei.service.LogRegService;

@Controller
public class LoginController {

	@Autowired
	private LogRegService logRegService;

	@RequestMapping("/loginPageEnter")
	public String loginPage(String redirectURL, Model model, Integer userAuth) {
		if (userAuth!=null&& userAuth== 0) {
			model.addAttribute("auth", "管理员");
		}
		model.addAttribute("redirectURL", redirectURL);
		return "login";
	}

	@RequestMapping("/loginProcess")
	public String loginProcess(String userName, String userPasswd, Model model,
			HttpServletRequest request, HttpServletResponse response,String redirectURL) {
		BookResult result = logRegService.loginProcess(userName, userPasswd,
				request,response);
		if (result.getStatus() == 400) {
			model.addAttribute("logError", result.getMsg());
			return "login";
		} else {
			if (redirectURL != null) {
				return "redirect:" + redirectURL;
			}
			return "redirect:/";
		}
	}

	@RequestMapping("/logoutProcess")
	public String logoutProcess(Model model, HttpServletRequest request,HttpServletResponse response) {
		BookResult result = logRegService.logoutProcess(request,response);
		if (result.getStatus() == 200) {
			model.addAttribute("sucInfo", "已安全退出，期待您的下一次光临");
			model.addAttribute("click", "返回首页");
			model.addAttribute("clickURL", "/");
			return "success";
		}
		return "error";
	}
	
	@RequestMapping("/autoLog")
	@ResponseBody
	public BookResult autoLog(HttpServletRequest request,HttpServletResponse response){
		logRegService.validateLog(request, response);
		return BookResult.ok();
	}
}
