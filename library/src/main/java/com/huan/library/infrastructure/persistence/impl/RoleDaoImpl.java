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

	public List<Role> selectAllRoles() throws Exception  {
		return null;
	}

	public Role selectById(String roleId) throws Exception  {
		return null;
	}

	public List<Role> selectByUserId(String userId) throws Exception  {
		return null;
	}

}
