package com.huan.library.infrastructure.persistence;
import java.util.List;

import com.huan.library.domain.model.rights.Function;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 下午03:26:49
 */
public interface FunctionDao extends BaseDao<Function>{

	/**
	 * 根据roleId查找所有的Function
	 * @param roleId
	 * @return
	 */
	public List<Function> selectFunctionsByRoleId(String roleId);
	
	/**
	 * 批量增加
	 * @param functions
	 * @throws Exception
	 */
	public void insertFunctionsBatch(List<Function> functions) throws Exception;
	
}
