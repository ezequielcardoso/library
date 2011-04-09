package com.huan.library.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.rights.Role;
import com.huan.library.domain.service.RoleService;
import com.huan.library.infrastructure.persistence.RoleDao;
import com.huan.library.web.view.RoleView;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao roleDao;

	public List<Role> findRoles(RoleView roleView) throws Exception {
		List<Role> roles = new ArrayList<Role>();
		try {
			roles = this.roleDao.selectRoles(roleView);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return roles;
	}

	public Role getById(Long roleId) throws Exception {
		Role role = new Role();
		try {
			role = this.roleDao.selectById(roleId);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return role;
	}

	public void remove(Role role) throws Exception {
		try {
			this.roleDao.delete(role);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public Role save(Role role) throws Exception {
		try {
			role = this.roleDao.saveOrUpdate(role);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return role;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
}
