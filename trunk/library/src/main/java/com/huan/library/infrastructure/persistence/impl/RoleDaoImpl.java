package com.huan.library.infrastructure.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.rights.Role;
import com.huan.library.infrastructure.persistence.RoleDao;
import com.huan.library.infrastructure.persistence.generic.HibernateDaoSupportBean;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 ����04:55:57
 */
@Repository("roleDao")
public class RoleDaoImpl extends HibernateDaoSupportBean implements RoleDao {

	public boolean deleteRole(Role role) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean saveOrUpdateRole(Role role) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Role> selectAllRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	public Role selectRoleById(String roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Role> selectRolesByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
