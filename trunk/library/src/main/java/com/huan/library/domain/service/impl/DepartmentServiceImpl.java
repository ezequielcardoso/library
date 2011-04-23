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

	public Department save(Department dept)  {
		return departmentDao.saveOrUpdate(dept);
	}

	public void remove(Department dept)  {
		this.departmentDao.delete(dept);
	}

	public Department getById(Long deptId)  {
		return this.departmentDao.getById(deptId);
	}

	public List<Department> getChildrenByPid(Long deptId)  {
		return this.departmentDao.selectChildrenByPid(deptId);
	}


}
