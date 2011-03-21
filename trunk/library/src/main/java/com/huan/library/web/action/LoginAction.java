package com.huan.library.web.action;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
/**
 * 登录action
 * @author huan
 * @time  2011-3-21 下午02:51:41
 */
@Controller("loginAction")
public class LoginAction extends BaseActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {
		return Action.SUCCESS;
	}

}
