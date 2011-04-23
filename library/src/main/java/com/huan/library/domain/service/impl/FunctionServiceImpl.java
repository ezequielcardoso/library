package com.huan.library.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.rights.Function;
import com.huan.library.domain.service.FunctionService;
import com.huan.library.infrastructure.persistence.FunctionDao;
import com.huan.library.web.view.FunctionView;


@Service("functionService")
public class FunctionServiceImpl implements FunctionService {
	
	private FunctionDao functionDao;

	@Autowired
	public void setFunctionDao(FunctionDao functionDao) {
		this.functionDao = functionDao;
	}

	public Function save(Function func)  {
		return functionDao.saveOrUpdate(func);
	}

	public List<Function> findAllFunctions()  {
		return null;
	}

	public List<Function> findByRoleId(FunctionView functionView) {
		return functionDao.selectByRoleId(functionView);
	}

	public Function getById(String funcId)  {
		return null;
	}

	public void remove(Function func)  {
		this.functionDao.delete(func);
	}

	public List<Function> findModules()  {
		List<Function> funcs = new ArrayList<Function>();
		try {
			List<Function> functions = functionDao.selectModules();
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

	public List<Function> findFunctions(FunctionView functionView) {
		return this.functionDao.selectFunctions(functionView);
	}

	public List<Function> findAll() {
		return this.functionDao.selectAll();
	}

}
