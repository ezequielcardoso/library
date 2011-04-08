package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.domain.model.rights.Role;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 下午04:58:26
 */
public interface RoleService {

	/**
	 * 增加或者修改角色
	 * @param role
	 * @return
	 */
	public Role save(Role role) throws Exception;
	
	/**
	 * 根据roleId删除角色
	 * @param role
	 * @return
	 */
	public void remove(Role role) throws Exception;
	
	/**
	 * 根据userId查找所有的角色
	 * @param userId
	 * @return
	 */
	public List<Role> findByUserId(String userId) throws Exception;
	
	/**
	 * 根据roleId查找角色
	 * @param roleId
	 * @return
	 */
	public Role getById(String roleId) throws Exception;
	
	/**
	 *查找所有的角色 
	 * @return
	 */
	public List<Role> findAllRoles() throws Exception;
	
}
