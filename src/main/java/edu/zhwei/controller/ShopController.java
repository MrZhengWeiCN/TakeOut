package edu.zhwei.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.zhwei.common.BookResult;
import edu.zhwei.common.PageOpt;
import edu.zhwei.pojo.Shop;
import edu.zhwei.pojo.ShopDetail;
import edu.zhwei.service.ShopService;

/**
 * 
 * <p>
 * Title: 购物车
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * github:
 * </p>
 * 
 * @date 2018-1-9 下午2:50:04
 * @author Zhwei
 */
@Controller
public class ShopController {

	@Autowired
	private ShopService shopService;

	@RequestMapping("/shoppingPageEnter")
	public String shoppingPage(HttpServletRequest request, Model model,
			@RequestParam(value = "page", defaultValue = "1") Integer page) {

		List<ShopDetail> details = shopService.findAllShopDetail(request);
		int endPage = PageOpt.pageRecord(details, PageOpt.SHOP);
		if (details != null && details.size() > 0) {
			Shop shop = new Shop();
			details = PageOpt.pageList(details, page, PageOpt.SHOP);
			shop.setList(details);
			
			model.addAttribute("endPage", endPage);
			model.addAttribute("startPage", 1);
			model.addAttribute("currPage", page);
			model.addAttribute("details", details);
			model.addAttribute("totalPrice", shop.getTotalPrice());
		}
		return "shopping";
	}

	/**
	 * URL:menuName,menuPrice
	 * 
	 * @param shopDetail
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/menuSubmit")
	public String addShop(ShopDetail shopDetail, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println(shopDetail.getMenuName());
		BookResult result = shopService
				.addDetail(shopDetail, request, response);
		if (result.getStatus() == 200) {
			model.addAttribute("sucInfo", "加入购物成功！");
			model.addAttribute("clickURL", "/shoppingPageEnter");
			model.addAttribute("OclickURL", "/");
			model.addAttribute("click", "查看购物车");
			model.addAttribute("Oclick", "继续购物");
			return "success";
		} else {
			return "error";
		}
	}

	@RequestMapping("/shoppingChange")
	public void changeShop(Integer menuId, String opt,
			HttpServletRequest request, String remark,
			HttpServletResponse response) {
		BookResult result = shopService.change(menuId, opt, request, remark,
				response);
	}
}
