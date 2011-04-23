package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.domain.model.rights.Department;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 下午04:47:57
 */
public interface DepartmentDao extends BaseDao<Department> {

	/**
	 * 根据Id查找Dept
	 * @param deptId
	 * @return
	 */
	public List<Department> selectChildrenByPid(Long parentDeptId)  ;

	public Department getById(Long deptId)  ;
	
}
