package com.huan.library.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.rights.Function;
import com.huan.library.domain.service.FunctionService;
import com.huan.library.infrastructure.persistence.FunctionDao;


@Service("functionService")
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
		List<Function> funcs = new ArrayList<Function>();
		try {
			List<Function> functions = functionDao.selectModuleFunctions();
			for(Function func : functions){
				if(func.getLevel()==1){
					funcs.add(func);
				}
			}
			for(int i=0; i<funcs.size(); i++){
				List<Function> children = new ArrayList<Function>();
				for(Function func : functions){
					if(func.getLevel()==2 && func.getParent().getFuncId().equals(funcs.get(i).getFuncId())){
						children.add(func);
					}
				}
				funcs.get(i).setChildren(children);
			}
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		for(Function func : funcs){
			System.out.println(func.getFuncName());
			List<Function> children = func.getChildren();
			for(Function child : children){
				System.out.println(child.getFuncName());
			}
		}
		return funcs;
	}

}
