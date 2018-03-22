package edu.zhwei.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zhwei.mapper.UserMapper;
import edu.zhwei.pojo.User;
import edu.zhwei.pojo.UserExample;
import edu.zhwei.pojo.UserExample.Criteria;

public class NameValidator implements Validator {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public boolean canRegist(String registType) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(registType);
		List<User> users = userMapper.selectByExample(example);
		if(users!=null&&users.size()>0){
			return false;
		}
		return true;
	}
}
