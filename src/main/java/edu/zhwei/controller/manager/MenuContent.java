package edu.zhwei.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.zhwei.common.PageOpt;
import edu.zhwei.pojo.Menu;
import edu.zhwei.service.MenuService;

@Controller
public class MenuContent {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/manMenuPageEnter")
	public String manuPage(Model model,@RequestParam(value = "page", defaultValue = "1") Integer page){
		List<Menu> menus = menuService.findAllMenu();
		java.util.Collections.reverse(menus);
		int endPage = PageOpt.pageRecord(menus, 10);
		menus = PageOpt.pageList(menus, page, 10);
		model.addAttribute("menus", menus);
		
		//pageinfo
		model.addAttribute("endPage", endPage);
		model.addAttribute("startPage", 1);
		model.addAttribute("currPage", page);
		return "manager/man_menu";
	}
	
	/**
	 * opt=menuAdd&menuName=
	 */
	@RequestMapping("/manMenuChange")
	public void menuChange(String opt,Menu menu,Integer id){
		menuService.menuChange(opt,menu,id);
	}
}
