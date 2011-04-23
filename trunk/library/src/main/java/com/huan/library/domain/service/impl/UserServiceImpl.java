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

	public User save(User user) {

		return this.userDao.saveOrUpdate(user);
	}

	public List<User> findUsers(UserView view) {

		return userDao.selectUsers(view);
	}

	public User getById(Long userId) {

		return userDao.getById(userId);
	}

	public void remove(User user) {

		userDao.delete(user);

	}

	public User getUserRole(User user) {
		return this.userDao.getUserRole(user);
	}

	public LoginState getUserLoginState(User user) {
		return this.userDao.getUserLoginState(user);
	}

}
