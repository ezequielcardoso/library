package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.domain.model.rights.Department;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 下午04:47:57
 */
public interface DepartmentDao {

	/**
	 * 增加或者修改Dept
	 * @param dept
	 * @return
	 */
	public Department saveOrUpdateDept(Department dept) throws Exception ;
	
	/**
	 * 根据id删除Dept
	 * @param dept
	 * @return
	 */
	public void deleteDept(Department dept) throws Exception ;
	
	/**
	 * 根据Id查找Dept
	 * @param deptId
	 * @return
	 */
	public Department selectDeptById(String deptId) throws Exception ;
	
	/**
	 * 根据Id查找Dept
	 * @param deptId
	 * @return
	 */
	public List<Department> selectDeptsByParentId(String parentDeptId) throws Exception ;
	
	/**
	 * 查找所有的Dept
	 * @return
	 */
	public List<Department> selectAllDepts() throws Exception ;
	
}
