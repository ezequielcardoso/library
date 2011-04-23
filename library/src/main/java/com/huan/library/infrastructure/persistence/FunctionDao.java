package com.huan.library.infrastructure.persistence;
import java.util.List;

import com.huan.library.domain.model.rights.Function;
import com.huan.library.web.view.FunctionView;

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
	public List<Function> selectByRoleId(FunctionView functionView) ;
	
	/**
	 * 批量增加
	 * @param functions
	 * @
	 */
	public void insertFunctionsBatch(List<Function> functions) ;
	
	/**
	 * 查找leve为1和2的所有功能
	 * @return
	 */
	public List<Function> selectModules() ;

	public List<Function> selectFunctions(FunctionView functionView);

	public List<Function> selectAll();

}
