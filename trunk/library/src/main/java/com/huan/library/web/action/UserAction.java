package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.rights.User;
import com.huan.library.domain.service.UserService;
import com.huan.library.web.view.UserView;
import com.opensymphony.xwork2.Action;

@Controller("userAction")
public class UserAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;
	
	private Map<String, Object> results = new HashMap<String, Object>();
	
	public Map<String, Object> getResults() {
		return results;
	}

	public void setResults(Map<String, Object> results) {
		this.results = results;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String index(){
		return Action.SUCCESS;
	}
	
	public String login(){
		return Action.SUCCESS;
	}
	
	public String findAllUsersInJson(){
		try {
			List<User> users = userService.findAllUsers();
			List<UserView> views = this.convertToView(users);
			results.put("rows", views);
			results.put("totalProperty", 8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
		
	}
	
	public List<UserView> convertToView(List<User> users ){
		List<UserView> views = new ArrayList<UserView>();
		for(User user : users){
			UserView view = new UserView();
			view.setUserId(user.getUserId());
			view.setCreateDate("");
			view.setUserAccount(user.getUserAccount());
			view.setUserName(user.getUserName());
			views.add(view);
		}
		return views;
	}
	
}
