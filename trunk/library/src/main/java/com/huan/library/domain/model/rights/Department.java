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

import com.huan.library.domain.model.reader.Reader;

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
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int deptId;//部门id
	private String depCode;//部门编号
	private String deptName;//部门全称
	private String deptShortName;//部门简称
	private String deptAlias;//别称
	private String deptDesc;//部门描述，介绍等
	
	@ManyToOne(targetEntity=Department.class,fetch=FetchType.LAZY)
	@JoinColumn(name="parentDeptId",referencedColumnName="deptId")
	private Department parent;//上级部门
	
	@OneToMany(targetEntity=Department.class,fetch=FetchType.LAZY)
	@JoinColumn(name="deptId")
	private List<Department> children = new ArrayList<Department>();//下级部门
	
	@OneToMany(fetch=FetchType.LAZY,cascade={CascadeType.ALL},mappedBy="department")
	private List<Reader> readers = new ArrayList<Reader>();  //读者


	public List<Reader> getReaders() {
		return readers;
	}

	public void setReaders(List<Reader> readers) {
		this.readers = readers;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
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

	public String getDepCode() {
		return depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode;
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

}
