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
	 * 根据roleId查找所有的Function
	 * @param roleId
	 * @return
	 */
	public List<Function> selectFunctionsByRoleId(String roleId) throws Exception;
	
	/**
	 * 查找所有的Function
	 * @return
	 */
	public List<Function> selectAllFunctions() throws Exception;

	/**
	 * 查找leve为1和2的所有功能
	 * @return
	 */
	public List<Function> selectModuleFunctions() throws Exception;
	
	/**
	 * 批量增加
	 * @param functions
	 * @throws Exception
	 */
	public void insertFunctionsBatch(List<Function> functions) throws Exception;
}
