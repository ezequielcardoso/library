package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.rights.User;
import com.huan.library.domain.service.UserService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private UserService userService;
	
	private List<User> users = new ArrayList<User>();
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String findAllUsersInJson(){
		try {
			users = userService.findAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
		
	}
	
	
}
