package com.huan.library.infrastructure.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.rights.Function;
import com.huan.library.infrastructure.persistence.FunctionDao;
import com.huan.library.infrastructure.persistence.generic.HibernateDaoSupportBean;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 ����04:55:51
 */
@Repository("functionDao")
public class FunctionDaoImpl extends HibernateDaoSupportBean implements
		FunctionDao {

	public boolean deleteFunction(Function func) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean saveOrUpdateFunction(Function func) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Function> selectAllFunctions() {
		// TODO Auto-generated method stub
		return null;
	}

	public Function selectFunctionById(String funcId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Function> selectFunctionsByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
