package edu.zhwei.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.zhwei.common.PageOpt;
import edu.zhwei.component.JedisClient;
import edu.zhwei.pojo.Comment;
import edu.zhwei.pojo.Menu;
import edu.zhwei.pojo.Menutype;
import edu.zhwei.service.CommentService;
import edu.zhwei.service.LogRegService;
import edu.zhwei.service.MenuService;

@Controller
public class PageController {

	@Autowired
	private MenuService menuService;
	@Autowired
	private LogRegService logRegService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private JedisClient jedisClient;

	// 将之前登陆过的用户显示出来
	@RequestMapping("/")
	public String index(HttpServletRequest request,
			HttpServletResponse response, Model model,
			@RequestParam(value = "page", defaultValue = "1") Integer page) {
		HttpSession session = request.getSession();
		List<Menutype> types = menuService.findAll();
		session.setAttribute("types", types);
		session.setMaxInactiveInterval(7 * 24 * 60 * 60);

		logRegService.validateLog(request, response);

		List<Menu> menus = menuService.findAllMenu();
		int endPage = PageOpt.pageRecord(menus, PageOpt.INDEX);
		menus = PageOpt.pageList(menus, page, PageOpt.INDEX);

		Set<String> wordRanges = jedisClient.zRevRange("searchWord", 0, 3);// 找到最热门的搜索关键词，并且列出来

		model.addAttribute("wordRanges", wordRanges);
		model.addAttribute("endPage", endPage);
		model.addAttribute("startPage", 1);
		model.addAttribute("menus", menus);
		model.addAttribute("currPage", page);
		return "index";
	}

	@RequestMapping("/{typeId}")
	public String typePage(@PathVariable Integer typeId, Model model,
			@RequestParam(value = "page", defaultValue = "1") Integer page) {
		List<Menu> menus = menuService.selectTypeMenu(typeId);
		Menutype menuType = menuService.findMenuTypeById(typeId);

		int endPage = PageOpt.pageRecord(menus, PageOpt.INDEX_TYPE);

		menus = PageOpt.pageList(menus, page, PageOpt.INDEX_TYPE);

		model.addAttribute("type", menuType);
		model.addAttribute("menus", menus);
		model.addAttribute("endPage", endPage);
		model.addAttribute("startPage", 1);
		model.addAttribute("currPage", page);
		return "index";
	}

	@RequestMapping("/menu/{menuId}")
	public String menu(Model model, @PathVariable Integer menuId,
			Integer userId,
			@RequestParam(value = "page", defaultValue = "1") Integer page) {
		Menu menu = menuService.findMenuById(menuId);
		if (menu == null) {
			return "error";
		}
		List<Comment> comments = commentService.findComments(menuId, userId);

		int endPage = PageOpt.pageRecord(comments, 10);
		comments = PageOpt.pageList(comments, page, 10);
		model.addAttribute("endPage", endPage);
		model.addAttribute("startPage", 1);
		model.addAttribute("currPage", page);

		model.addAttribute("comments", comments);
		model.addAttribute("menu", menu);
		return "comment/Newcomment";
	}

	@RequestMapping("/frequentError")
	public String errorPage() {
		return "frequentError";
	}
}
