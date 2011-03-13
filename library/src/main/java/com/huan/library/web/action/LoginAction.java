package com.huan.library.web.action;

import com.huan.library.domain.model.rights.User;
import com.huan.library.web.action.generic.BaseActionSupport;
import com.opensymphony.xwork2.Action;
/**
 * 登录action
 * @author huan
 * @time  2011-3-12 下午02:58:29
 */
public class LoginAction extends BaseActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		session.put("user", user);
		return Action.SUCCESS;
	}
	
	

}