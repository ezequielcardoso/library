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
	public Department save(Department dept) throws Exception;
	
	/**
	 * 根据id删除Dept
	 * @param dept
	 * @return
	 */
	public void remove(Department dept) throws Exception;
	
	/**
	 * 根据Id查找Dept
	 * @param deptId
	 * @return
	 */
	public Department getById(Long deptId) throws Exception;
	
	/**
	 * 根据Id查找Dept
	 * @param deptId
	 * @return
	 */
	public List<Department> getChildrenByPid(Long deptId) throws Exception;
	
}
