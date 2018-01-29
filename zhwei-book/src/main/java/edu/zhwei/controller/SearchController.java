package edu.zhwei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.zhwei.common.PageOpt;
import edu.zhwei.pojo.SearchMenu;
import edu.zhwei.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@RequestMapping("/search")
	public String search(@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows,Model model){
		
		List<SearchMenu> serachMenu = searchService.search(keyword);
		int endPage = PageOpt.pageRecord(serachMenu, 10);
		serachMenu = PageOpt.pageList(serachMenu, page, 10);
		model.addAttribute("endPage", endPage);
		model.addAttribute("startPage", 1);
		model.addAttribute("currPage", page);
		model.addAttribute("menus", serachMenu);
		model.addAttribute("keyword", keyword);
		return "searchResult";
	}
}
