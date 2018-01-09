package edu.zhwei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * <p>Title: 购物车</p>
 * <p>Description: </p>
 * <p>github: </p>
 * @date 2018-1-9 下午2:50:04
 * @author Zhwei
 */
@Controller
public class ShopController {

	@RequestMapping("/shoppingPageEnter")
	public String shoppingPage(){
		return "shopping";
	}
}
