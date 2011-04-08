package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.domain.model.rights.Role;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 下午04:55:19
 */
public interface RoleDao {

	/**
	 * 根据userId查找所有的角色
	 * @param userId
	 * @return
	 */
	public List<Role> selectByUserId(String userId) throws Exception ;
	
	/**
	 * 根据roleId查找角色
	 * @param roleId
	 * @return
	 */
	public Role selectById(String roleId) throws Exception ;
	
	/**
	 *查找所有的角色 
	 * @return
	 */
	public List<Role> selectAllRoles() throws Exception ;
	
}
