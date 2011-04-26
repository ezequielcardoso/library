package com.huan.library.web.view;

import java.io.Serializable;

import com.huan.library.web.view.grid.ExtGridPost;

/**
 * 角色 视图
 * @author shuaizhichun
 * @time 2011-3-6 下午10:27:23
 */
public class RoleView extends ExtGridPost implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer roleId;//角色id
	private String roleName;//角色名字
	private String roleDesc;//角色描述
	private Boolean roleActive;//角色激活
	private String createDate;//角色修改时间
	private Long userId;
	private Boolean checked;
	private String[] funcIds;
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Boolean getRoleActive() {
		return roleActive;
	}

	public void setRoleActive(Boolean roleActive) {
		this.roleActive = roleActive;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public String[] getFuncIds() {
		return funcIds;
	}

	public void setFuncIds(String[] funcIds) {
		this.funcIds = funcIds;
	}

}
