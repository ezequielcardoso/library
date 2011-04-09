package com.huan.library.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.constant.LoginState;
import com.huan.library.domain.model.rights.User;
import com.huan.library.domain.service.UserService;
import com.huan.library.infrastructure.persistence.UserDao;
import com.huan.library.web.view.UserView;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User save(User user)  throws Exception{
		User rtnUser = new User();
		try {
			rtnUser = this.userDao.saveOrUpdate(user);
		} catch (Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return rtnUser;
	}

	public List<User> findUsers(UserView view) throws Exception {
		List<User> users = new ArrayList<User>();
		try {
			users = userDao.selectUsers(view);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return users;
	}

	public User getById(Long userId) throws Exception {
		User user = new User();
		try {
			user = userDao.getById(userId);
		} catch (Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return user;
	}

	public void remove(User user) throws Exception {
		try {
			userDao.delete(user);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public User getUserRole(User user) throws Exception {
		return this.userDao.getUserRole(user);
	}

	public LoginState getUserLoginState(User user) throws Exception {
		return this.userDao.getUserLoginState(user);
	}

}
