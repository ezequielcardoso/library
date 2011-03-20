package com.huan.library.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.huan.library.domain.model.rights.Function;
import com.huan.library.domain.service.FunctionService;
import com.huan.library.infrastructure.persistence.FunctionDao;


public class FunctionServiceImpl implements FunctionService {
	
	private FunctionDao functionDao;

	@Autowired
	public void setFunctionDao(FunctionDao functionDao) {
		this.functionDao = functionDao;
	}

	public boolean addOrModifyFunction(Function func) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Function> findAllFunctions() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Function> findFunctionsByRoleId(String roleId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Function loadFunctionById(String funcId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeFunction(Function func) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Function> findModuleFunctions() throws Exception {
		List<Function> functions = new ArrayList<Function>();
		try {
			functions = functionDao.selectModuleFunctions();
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return functions;
	}

}
