package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.domain.model.rights.Function;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 下午04:58:12
 */
public interface FunctionService {

	/**
	 * 保存或者修改Function
	 * @param func
	 * @return
	 */
	public Function save(Function func) throws Exception;
	
	/**
	 * 根据funcId 删除Function
	 * @param func
	 * @return
	 */
	public void remove(Function func) throws Exception;
	
	/**
	 * 根据funcId 查找Function
	 * @param funcId
	 * @return
	 */
	public Function getById(String funcId) throws Exception;
	
	/**
	 * 根据roleId查找所有的Function
	 * @param roleId
	 * @return
	 */
	public List<Function> findByRoleId(String roleId) throws Exception;
	
	/**
	 * 查找模块菜单的Function
	 * @return
	 */
	public List<Function> findModules() throws Exception;
}
