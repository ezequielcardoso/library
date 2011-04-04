package com.huan.library.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.constant.LoginState;
import com.huan.library.domain.model.rights.User;
import com.huan.library.domain.service.UserService;
import com.huan.library.web.view.UserView;
import com.huan.library.web.view.form.ExtJsonForm;
import com.huan.library.web.view.grid.ExtGridLoad;
import com.opensymphony.xwork2.Action;

@Controller("userAction")
public class UserAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static Logger logger = Logger.getLogger(UserAction.class.getName());
	
	@Autowired
	private UserService userService;
	
	private User user = new User();
	private UserView userView = new UserView();
	private ExtJsonForm extJsonForm = new ExtJsonForm();
	private ExtGridLoad extGridLoad = new ExtGridLoad(); 
	private Integer start;
	private Integer limit;
	
	public String loginVerify(){
		logger.info("目前登录的用户为:" + user);
		LoginState loginState = null;
		try {
			System.out.println(user.getUserName() + "-" + user.getPassword());
			loginState = userService.getUserLoginState(user);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}		
		logger.info("登录验证状态为:" + loginState);
		
		switch(loginState){
			case ERROR_PWD_USER :{
				extJsonForm.setSuccess(false);
				extJsonForm.setData("用户名或密码错误!");
			}
			break;
			case PASS :{
				try {
					user = userService.getUserRole(user);
				} catch (Exception e) {
					e.printStackTrace();
					return Action.ERROR;
				}
				this.session.put("currUser", user);
				extJsonForm.setSuccess(true);
				extJsonForm.setData("登录成功");
			}
			break;
		}
		return Action.SUCCESS;	
	}
	
	public String loginOff(){
		if(request.getSession() != null){
			request.getSession().invalidate();
		}
//		response.sendRedirect(request.getContextPath()+ "/index.jsp?message=logoff");
		return Action.SUCCESS;
	}
	
	public String findUsers(){
		try {
			userView.setStart(start);
			userView.setLimit(limit);
			List<User> users = userService.findUsers(userView);
			extGridLoad.setRoot(this.convertToView(users));
			extGridLoad.setTotalProperty(userView.getTotalCount());
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

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ExtJsonForm getExtJsonForm() {
		return extJsonForm;
	}

	public void setExtJsonForm(ExtJsonForm extJsonForm) {
		this.extJsonForm = extJsonForm;
	}

	public ExtGridLoad getExtGridLoad() {
		return extGridLoad;
	}

	public void setExtGridLoad(ExtGridLoad extGridLoad) {
		this.extGridLoad = extGridLoad;
	}

	public UserView getUserView() {
		return userView;
	}

	public void setUserView(UserView userView) {
		this.userView = userView;
	}
	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

}
