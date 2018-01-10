package edu.zhwei.controller.manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zhwei.common.BookResult;
import edu.zhwei.pojo.Menutype;
import edu.zhwei.service.MenuService;

@Controller
public class Type {
	
	@Autowired
	private MenuService menuService;

	@RequestMapping("/manMenuTypePageEnter")
	public String type(Model model){
		List<Menutype> types = menuService.findAll();
		model.addAttribute("menutypes", types);
		return "manager/man_menu_type";
	}
	
	/**
	 * ?opt=menuTypeAdd&page=${currPage}&menuTypeName=
	 */
	@RequestMapping("/manMenuTypeChange")
	public void typeChange(String opt,String menuTypeName,Integer id,HttpServletRequest request){
		BookResult result = menuService.doOpt(opt,menuTypeName,id);
		//修改完以后要进行同步
		HttpSession session = request.getSession();
		List<Menutype> types = menuService.findAll();
		session.setAttribute("types", types);
		session.setMaxInactiveInterval(7*24*60*60);
	}
	
}
