package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.constant.LoginState;
import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.rights.User;
import com.huan.library.domain.service.UserService;
import com.huan.library.util.DateFormatUtil;
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
	
	public String save() {
		try {
			user = userService.save(user);
			extJsonForm.setSuccess(true);
			extJsonForm.setMsg("保存成功！");
			extJsonForm.setData(user);
		} catch (Exception e) {
			e.printStackTrace();
			extJsonForm.setSuccess(false);
			extJsonForm.setMsg("保存失败！");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	public String remove() {
		try {
			User user = new User();
			user.setUserId(userView.getUserId());
			// 这里可以取到值
			userService.remove(user);
			extJsonForm.setSuccess(true);
			extJsonForm.setMsg("删除成功！");
			extJsonForm.setData(null);
		} catch (Exception e) {
			e.printStackTrace();
			extJsonForm.setSuccess(false);
			extJsonForm.setMsg("删除失败！");
			extJsonForm.setData(null);
			return Action.ERROR;
		}
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
		for(int i=0; i<users.size(); i++){
			UserView view = new UserView();
			view.setUserId(users.get(i).getUserId());
			if(users.get(i).getPassword()!=null){
				view.setPassword(users.get(i).getPassword());
			}
			if(users.get(i).getCreateDate()!=null){
				view.setCreateDate(DateFormatUtil.format(users.get(i).getCreateDate(), "yyyy-MM-dd"));
			}
			if(users.get(i).getUserActive()!=null){
				view.setUserAccount(users.get(i).getUserAccount());
			}
			if(users.get(i).getUserName()!=null){
				view.setUserName(users.get(i).getUserName());
			}
			if(users.get(i).getUserActive()!=null){
				view.setUserActive(users.get(i).getUserActive());
			}
			if(users.get(i).getDept()!=null){
				view.setDeptId(users.get(i).getDept().getDeptId());
				view.setDeptName(users.get(i).getDept().getDeptName());
			}
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
