package com.huan.library.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.huan.library.domain.model.rights.User;
import com.huan.library.domain.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	public boolean addOrModifyUser(User user)  throws Exception{
		// TODO Auto-generated method stub
		return false;
	}

	public List<User> findAllUsers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findUsersByDeptId(String deptId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserById(String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
