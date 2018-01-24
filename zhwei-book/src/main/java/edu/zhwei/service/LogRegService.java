package edu.zhwei.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import edu.zhwei.common.BookResult;
import edu.zhwei.pojo.User;

public interface LogRegService {

	BookResult validateReg(User user);
	BookResult loginProcess(String userName,String userPasswd,HttpServletRequest request,HttpServletResponse response);
	BookResult logoutProcess(HttpServletRequest request,HttpServletResponse response);
	void validateLog(HttpServletRequest request,HttpServletResponse response);
	
}
