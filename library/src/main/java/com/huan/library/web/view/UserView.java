package com.huan.library.web.view;

public class UserView {

	private int userId;// 用户id
	private String userAccount;// 账号
	private String userName;// 姓名
	private String password;// 密码
	private boolean userActive;// 是否激活
	private String createDate;// 修改日期

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isUserActive() {
		return userActive;
	}

	public void setUserActive(boolean userActive) {
		this.userActive = userActive;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
