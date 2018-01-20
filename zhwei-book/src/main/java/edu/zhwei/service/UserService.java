package edu.zhwei.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import edu.zhwei.common.BookResult;
import edu.zhwei.pojo.User;

public interface UserService {

	BookResult Update(User user,HttpServletRequest request,String userOldPasswd);

	List<User> findAll();
}
