package com.huan.library.infrastructure.persistence;
import java.util.List;

import com.huan.library.domain.model.rights.Function;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 下午03:26:49
 */
public interface FunctionDao {

	/**
	 * 保存或者修改Function
	 * @param func
	 * @return
	 */
	public boolean saveOrUpdateFunction(Function func);
	
	/**
	 * 根据funcId 删除Function
	 * @param func
	 * @return
	 */
	public boolean deleteFunction(Function func);
	
	/**
	 * 根据funcId 查找Function
	 * @param funcId
	 * @return
	 */
	public Function selectFunctionById(String funcId);
	
	/**
	 * 根据roleId查找所有的Function
	 * @param roleId
	 * @return
	 */
	public List<Function> selectFunctionsByRoleId(String roleId);
	
	/**
	 * 查找所有的Function
	 * @return
	 */
	public List<Function> selectAllFunctions();
}
