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

	public Department save(Department dept)  throws Exception{
		try {
			departmentDao.saveOrUpdate(dept);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return null;
	}

	public void remove(Department dept) throws Exception {
		try {
			this.departmentDao.delete(dept);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public Department getById(Long deptId) throws Exception {
		Department dept = new Department();
		try {
			dept = this.departmentDao.getById(deptId);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return dept;
	}

	public List<Department> getChildrenByPid(Long deptId) throws Exception {
		List<Department> depts = new ArrayList<Department>();
		try {
			depts = this.departmentDao.selectChildrenByPid(deptId);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return depts;
	}


}
