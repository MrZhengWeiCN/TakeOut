package edu.zhwei.search.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zhwei.search.commons.BookResult;
import edu.zhwei.search.pojo.SearchMenu;
import edu.zhwei.search.service.MenuService;

@Controller
public class SearchController {

	@Autowired
	private MenuService menuService;

	@RequestMapping("/importMenu")
	@ResponseBody
	public BookResult importMenus() {
		try {
			BookResult result = menuService.importMenus();
			return result;
		} catch (Exception e) {
			return BookResult.build(400, e.getMessage());
		}
	}

	@RequestMapping("/q")
	@ResponseBody
	public List<SearchMenu> search(
			@RequestParam(defaultValue = "") String keyword) {
		try {
			keyword = URLDecoder.decode(keyword, "utf-8");
			try {
				List<SearchMenu> result = menuService.search(keyword);
				return result;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
