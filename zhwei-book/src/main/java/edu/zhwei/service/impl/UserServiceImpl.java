package edu.zhwei.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zhwei.common.BookResult;
import edu.zhwei.mapper.UserMapper;
import edu.zhwei.pojo.User;
import edu.zhwei.pojo.UserExample;
import edu.zhwei.pojo.UserExample.Criteria;
import edu.zhwei.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public BookResult Update(User user, HttpServletRequest request,String userOldPasswd) {
		//修改只能改密码，电话,地址，地址不需要校验
		//先校验旧的密码是否正确
		User oldUser = userMapper.selectByPrimaryKey(user.getUserId());
		if(!oldUser.getUserPasswd().equals(userOldPasswd))
			return BookResult.build(400, "原密码错误！");
		if(!user.getUserTel().equals(oldUser.getUserTel())){
			UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			criteria.andUserTelEqualTo(user.getUserTel());
			List<User> lists = userMapper.selectByExample(example );
			if(lists!=null&&lists.size()>0){
				return BookResult.build(400, "新号码已被注册！");
			}
		}
		userMapper.updateByPrimaryKey(user);
		//同步更新session中的user
		request.removeAttribute("user");
		return BookResult.ok();
	}

	@Override
	public List<User> findAll() {
		UserExample example = new UserExample();
		List<User> users = userMapper.selectByExample(example );
		return users;
	}
}
