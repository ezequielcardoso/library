package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.domain.model.rights.Role;
import com.huan.library.web.view.RoleView;

/**
 * 
 * @author shuaizhichun
 * 2010-4-9
 */
public interface RoleDao  extends BaseDao<Role>{

	/**
	 * 根据roleId查找角色
	 * @param roleId
	 * @return
	 */
	public Role selectById(Long roleId)  ;
	
	/**
	 *查找所有的角色 
	 * @return
	 */
	public List<Role> selectRoles(RoleView view)  ;
	
}
