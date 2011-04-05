package com.huan.library.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.rights.Department;
import com.huan.library.domain.service.DepartmentService;
import com.huan.library.infrastructure.persistence.DepartmentDao;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public void addOrModifyDept(Department dept)  throws Exception{
		try {
			departmentDao.saveOrUpdate(dept);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public void removeDept(Department dept) throws Exception {
		try {
			this.departmentDao.delete(dept);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public Department getDeptById(Long deptId) throws Exception {
		Department dept = new Department();
		try {
			dept = this.departmentDao.selectDeptById(deptId);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return dept;
	}

	public List<Department> getDeptsByParentId(Long deptId) throws Exception {
		List<Department> depts = new ArrayList<Department>();
		try {
			depts = this.departmentDao.selectDeptsByParentId(deptId);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return depts;
	}

}
