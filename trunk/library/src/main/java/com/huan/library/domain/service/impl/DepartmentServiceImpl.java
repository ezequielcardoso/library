package com.huan.library.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.huan.library.domain.model.rights.Department;
import com.huan.library.domain.service.DepartmentService;
import com.huan.library.infrastructure.persistence.DepartmentDao;


public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public void addOrModifyDept(Department dept)  throws Exception{
			  departmentDao.saveOrUpdate(dept);
	}

	public List<Department> getDeptByParentId(String parentDeptId) throws Exception {
		List<Department> depts = new ArrayList<Department>();
		try {
		} catch(Exception e){
			
		}
		return null;
	}

	public void removeDept(Department dept) throws Exception {
		// TODO Auto-generated method stub
	}

	public Department getDeptById(String deptId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Department> getDeptsByParentId(String deptId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
