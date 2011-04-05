package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.domain.model.rights.Department;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 下午04:57:09
 */
public interface DepartmentService {

	/**
	 * 增加或者修改Dept
	 * @param dept
	 * @return
	 */
	public void addOrModifyDept(Department dept) throws Exception;
	
	/**
	 * 根据id删除Dept
	 * @param dept
	 * @return
	 */
	public void removeDept(Department dept) throws Exception;
	
	/**
	 * 根据Id查找Dept
	 * @param deptId
	 * @return
	 */
	public Department getDeptById(Long deptId) throws Exception;
	
	/**
	 * 根据Id查找Dept
	 * @param deptId
	 * @return
	 */
	public List<Department> getDeptsByParentId(Long deptId) throws Exception;
	
}
