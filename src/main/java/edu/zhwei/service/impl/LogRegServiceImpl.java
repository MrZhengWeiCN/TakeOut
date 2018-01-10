package edu.zhwei.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.zhwei.common.BookResult;
import edu.zhwei.mapper.UserMapper;
import edu.zhwei.pojo.User;
import edu.zhwei.pojo.UserExample;
import edu.zhwei.pojo.UserExample.Criteria;
import edu.zhwei.service.LogRegService;

@Service
public class LogRegServiceImpl implements LogRegService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public BookResult validateReg(User user) {
		//只需要校验用户名，电话
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(user.getUserName());
		List<User> users = userMapper.selectByExample(example);
		if(users!=null&&users.size()>0){
			return BookResult.build(400, "用户名已被占用！");
		}
		example = new UserExample();
		criteria = example.createCriteria();
		criteria.andUserTelEqualTo(user.getUserTel());
		users = userMapper.selectByExample(example);
		if(users!=null&&users.size()>0){
			return BookResult.build(400, "手机号码已经被注册！");
		}
		//开始插入数据库中
		try {
			userMapper.insert(user);
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400, "注册错误，请重试！");
		}
	}

	@Override
	public BookResult loginProcess(String userName, String userPasswd,HttpServletRequest request) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		criteria.andUserPasswdEqualTo(userPasswd);
		List<User> users = userMapper.selectByExample(example );
		if(users==null||users.size()==0){
			return BookResult.build(400, "用户名或密码错误！");
		}
		User user = users.get(0);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		return BookResult.ok();
	}

	@Override
	public BookResult logoutProcess(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return BookResult.ok();
	}
}
