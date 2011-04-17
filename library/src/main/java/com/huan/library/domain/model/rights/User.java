package com.huan.library.domain.model.rights;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



/**
 * 用户
 * @author shuaizhichun
 * @time 2011-3-6 下午10:27:58
 */
@Entity
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;//用户id
	private String userAccount;//账号
	private String userName;//姓名
	private String password;//密码
	private Boolean userActive;//是否激活
	private Date createDate;//修改日期
	
	//拥有的所有角色对象
	@ManyToMany
	@JoinTable(name="UserRole",
		joinColumns=@JoinColumn(name="userId",referencedColumnName="userId"),
		inverseJoinColumns=@JoinColumn(name="roleId",referencedColumnName="roleId"))
	private List<Role> roles = new ArrayList<Role>();
	
	//所属的单位或者部门
	@ManyToOne(targetEntity=Department.class,fetch=FetchType.LAZY)
	@JoinColumn(name="deptId",referencedColumnName="deptId")
	private Department dept;
	
	public User(){
		
	}
	
	public User(Long userId, String userAccount, String userName, String password, Boolean userActive, 
			Date createDate, Long deptId, String deptName){
		this.userId = userId;
		this.userAccount = userAccount;
		this.userName = userName;
		this.password = password;
		this.userActive = userActive;
		this.createDate = createDate;
		Department dept = new Department();
		dept.setDeptId(deptId);
		dept.setDeptName(deptName);
		this.dept = dept;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
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

	public Boolean getUserActive() {
		return userActive;
	}

	public void setUserActive(Boolean userActive) {
		this.userActive = userActive;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

}
