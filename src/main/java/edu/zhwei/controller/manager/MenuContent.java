package edu.zhwei.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.zhwei.common.BookResult;
import edu.zhwei.pojo.Menu;
import edu.zhwei.service.MenuService;

@Controller
public class MenuContent {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/manMenuPageEnter")
	public String manuPage(Model model){
		List<Menu> menus = menuService.findAllMenu();
		model.addAttribute("menus", menus);
		return "manager/man_menu";
	}
	
	/**
	 * opt=menuAdd&menuName=
	 */
	@RequestMapping("/manMenuChange")
	public void menuChange(String opt,Menu menu){
		BookResult result = menuService.menuChange(opt,menu);
	}
}
