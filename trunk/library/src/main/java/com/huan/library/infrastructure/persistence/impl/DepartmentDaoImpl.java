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

	public boolean deleteDept(Department dept) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean saveOrUpdateDept(Department dept) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Department> selectAllDepts() {
		// TODO Auto-generated method stub
		return null;
	}

	public Department selectDeptById(String deptId) {
		// TODO Auto-generated method stub
		return null;
	}

}
