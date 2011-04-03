package com.huan.library.domain.model.rights;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;

/**
 * 角色 
 * @author shuaizhichun
 * @time 2011-3-6 下午10:27:23
 */
@Entity
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer roleId;//角色id
	private String roleName;//角色名字
	private String roleDesc;//角色描述
	private boolean roleActive;//角色激活
	private Date createDate;//角色修改时间
	
	@ManyToMany(
			mappedBy="roles",targetEntity=User.class)
	private List<User> users = new ArrayList<User>();//所属该角色的所有用户
	
	@ManyToMany
	@JoinTable(name="RoleFunction",
			joinColumns=@JoinColumn(name="roleId",referencedColumnName="roleId"),
			inverseJoinColumns=@JoinColumn(name="funcId",referencedColumnName="funcId"))
	@OrderBy("funcOrder ASC")		
	private List<Function> functions = new ArrayList<Function>();//角色拥有的所有功能

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

	public boolean isRoleActive() {
		return roleActive;
	}

	public void setRoleActive(boolean roleActive) {
		this.roleActive = roleActive;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}
	
}
