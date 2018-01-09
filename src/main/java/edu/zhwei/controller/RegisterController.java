package edu.zhwei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

	@RequestMapping("/regPageEnter")
	public String regPage(){
		return "reg";
	}
}
