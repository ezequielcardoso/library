package com.huan.library.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.rights.User;
import com.huan.library.domain.service.UserService;
import com.huan.library.infrastructure.persistence.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean addOrModifyUser(User user)  throws Exception{
		// TODO Auto-generated method stub
		return false;
	}

	public List<User> findAllUsers() throws Exception {
		return userDao.selectAllUsers();
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
