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
	 * 增加或者修改角色
	 * @param role
	 * @return
	 */
	public boolean saveOrUpdateRole(Role role);
	
	/**
	 * 根据roleId删除角色
	 * @param role
	 * @return
	 */
	public boolean deleteRole(Role role);
	
	/**
	 * 根据userId查找所有的角色
	 * @param userId
	 * @return
	 */
	public List<Role> selectRolesByUserId(String userId);
	
	/**
	 * 根据roleId查找角色
	 * @param roleId
	 * @return
	 */
	public Role selectRoleById(String roleId);
	
	/**
	 *查找所有的角色 
	 * @return
	 */
	public List<Role> selectAllRoles();
	
}
