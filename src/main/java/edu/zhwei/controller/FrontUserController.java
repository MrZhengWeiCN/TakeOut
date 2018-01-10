package edu.zhwei.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.zhwei.common.BookResult;
import edu.zhwei.pojo.User;
import edu.zhwei.service.UserService;

/**
 * 前台用户的管理
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * github:
 * </p>
 * 
 * @date 2018-1-10 下午3:39:10
 * @author Zhwei
 */
@Controller
public class FrontUserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/perInfoPageEnter")
	public String perInfoPage() {
		return "perinfo";
	}

	@RequestMapping("/perInfoProcess")
	public String perInfoProcess(String userOldPasswd,User user, HttpServletRequest request,
			 Model model) {
		BookResult result = userService.Update(user, request, userOldPasswd);
		if(result.getStatus()==400){
			model.addAttribute("perInfoError", result.getMsg());
			return "perinfo";
		}else {
			model.addAttribute("sucInfo", "个人信息成功修改！");
			model.addAttribute("clickURL", "/loginPageEnter");
			model.addAttribute("click", "请重新登陆");
			return "success";
		}
	}

}
