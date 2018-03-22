package edu.zhwei.service.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zhwei.common.BookResult;
import edu.zhwei.common.CookieUtils;
import edu.zhwei.common.JsonUtils;
import edu.zhwei.common.Validator;
import edu.zhwei.common.ValidatorFactory;
import edu.zhwei.component.JedisClient;
import edu.zhwei.mapper.UserMapper;
import edu.zhwei.pojo.User;
import edu.zhwei.pojo.UserExample;
import edu.zhwei.pojo.UserExample.Criteria;
import edu.zhwei.service.LogRegService;

@Service
public class LogRegServiceImpl implements LogRegService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private JedisClient jedisClient;
	
	@Override
	public BookResult validateReg(User user) {
		//只需要校验用户名，电话
		Validator validator = ValidatorFactory.getNameValidator();
		if(!validator.canRegist(user.getUserName())){
			return BookResult.build(400, "用户名已被占用！");
		}
		validator = ValidatorFactory.getPhoneValidator();
		if(!validator.canRegist(user.getUserTel())){
			return BookResult.build(400, "手机号码已经被注册！");
		}
		try {
			userMapper.insert(user);
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400, "注册错误，请重试！");
		}
	}

	@Override
	public BookResult loginProcess(String userName, String userPasswd,HttpServletRequest request,HttpServletResponse response) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		criteria.andUserPasswdEqualTo(userPasswd);
		List<User> users = userMapper.selectByExample(example );
		if(users==null||users.size()==0){
			return BookResult.build(400, "用户名或密码错误！");
		}
		User user = users.get(0);
		//将token写入cookie中
		String token = UUID.randomUUID().toString();
		CookieUtils.setCookie(request, response, "TOKEN", token, 24*60*60);
		String userJson = JsonUtils.objectToJson(user);
		//将token——user对写入redis
		jedisClient.set("user:"+token, userJson);
		jedisClient.expire("user:"+token, 24*60*60);
		HttpSession session = request.getSession();
		//将User写入session
		session.setAttribute("user", user);
		return BookResult.ok();
	}

	@Override
	public BookResult logoutProcess(HttpServletRequest request,HttpServletResponse response) {
		String token = CookieUtils.getCookieValue(request, "TOKEN");
		jedisClient.del("user:"+token);
		CookieUtils.deleteCookie(request, response, "TOKEN");
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return BookResult.ok();
	}

	@Override
	public void validateLog(HttpServletRequest request,
			HttpServletResponse response) {
		//从cookie获得token，根据token从redis获得user，放入session中。
		String token = CookieUtils.getCookieValue(request, "TOKEN");
		String userJson = jedisClient.get("user:"+token);
		if(userJson!=null){
			User user = JsonUtils.jsonToPojo(userJson, User.class);
			jedisClient.expire("user:"+token, 24*60*60);
			request.getSession().setAttribute("user", user);
		}
	}
}
