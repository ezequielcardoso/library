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
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	public List<Role> findRoles(RoleView roleView) {
		return this.roleDao.selectRoles(roleView);
	}

	public Role getById(Long roleId) {
		return this.roleDao.selectById(roleId);
	}

	public void remove(Role role) {

		this.roleDao.delete(role);

	}

	public Role save(Role role) {

		return this.roleDao.saveOrUpdate(role);
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

}
