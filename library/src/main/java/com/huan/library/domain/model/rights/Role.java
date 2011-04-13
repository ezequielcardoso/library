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
	private Boolean roleActive;//角色激活
	private Date createDate;//角色修改时间
	private Boolean checked;
	
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
	public Boolean getRoleActive() {
		return roleActive;
	}

	public void setRoleActive(Boolean roleActive) {
		this.roleActive = roleActive;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}

}
