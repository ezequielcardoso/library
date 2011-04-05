package com.huan.library.domain.model.rights;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



/**
 * 部门
 * @author shuaizhichun
 * @time 2011-3-6 下午10:25:55
 */


@Entity
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long deptId;//部门id
	private String deptCode;//部门编号
	private String deptName;//部门全称
	private String deptShortName;//部门简称
	private String deptAlias;//别称
	private String deptDesc;//部门描述，介绍等
	private Boolean leaf;
	
	@ManyToOne(targetEntity=Department.class,fetch=FetchType.LAZY,cascade={CascadeType.MERGE,CascadeType.REMOVE})
	@JoinColumn(name="parentDeptId",referencedColumnName="deptId")
	private Department parent;//上级部门
	
	@OneToMany(targetEntity=Department.class,mappedBy="parent")
	private List<Department> children = new ArrayList<Department>();//下级部门
	
	/**
	 * default constructor
	 */
	public Department( ){
		
	}
	
	public Department(Long deptId, String deptCode, String deptName, String deptShortName, 
			String deptAlias, String deptDesc, Long parentDeptId, String parentDeptName, String parentDeptCode){
		this.deptId = deptId;
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.deptShortName = deptShortName;
		this.deptAlias = deptAlias;
		this.deptDesc = deptDesc;
		Department parent = new Department();
		parent.setDeptId(parentDeptId);
		parent.setDeptName(parentDeptName);
		parent.setDeptCode(parentDeptCode);
		this.setParent(parent);
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	public List<Department> getChildren() {
		return children;
	}

	public void setChildren(List<Department> children) {
		this.children = children;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptShortName() {
		return deptShortName;
	}

	public void setDeptShortName(String deptShortName) {
		this.deptShortName = deptShortName;
	}

	public String getDeptAlias() {
		return deptAlias;
	}

	public void setDeptAlias(String deptAlias) {
		this.deptAlias = deptAlias;
	}

	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

}
