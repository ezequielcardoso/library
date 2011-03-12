package com.huan.library.infrastructure.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.rights.Department;
import com.huan.library.infrastructure.persistence.DepartmentDao;
import com.huan.library.infrastructure.persistence.generic.HibernateDaoSupportBean;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 ����04:55:44
 */
@Repository("departmentDao")
public class DepartmentDaoImpl extends HibernateDaoSupportBean implements
		DepartmentDao {

	public void deleteDept(Department dept) throws Exception {
		this.getHibernateTemplate().delete(dept);
	}

	public Department saveOrUpdateDept(Department dept) throws Exception {
		return dept;
	}

	public List<Department> selectAllDepts() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Department selectDeptById(String deptId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Department> selectDeptsByParentId(String parentDeptId)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
