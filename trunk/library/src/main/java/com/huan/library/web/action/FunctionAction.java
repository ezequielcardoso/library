package com.huan.library.web.action;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.rights.Function;
import com.huan.library.domain.service.FunctionService;
import com.opensymphony.xwork2.Action;

/**
 * 
 * @author shuaizhichun
 * @time 2011-3-21 上午01:45:56
 */
@Controller("functionAction")
public class FunctionAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Function> moduleFunctions = new ArrayList<Function>();
	
	@Autowired
	private FunctionService functionService ;
	
	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}

	public List<Function> getModuleFunctions() {
		return moduleFunctions;
	}

	public void setModuleFunctions(List<Function> moduleFunctions) {
		this.moduleFunctions = moduleFunctions;
	}

	/**
	 * 查找系统模块功能
	 * @return
	 * @throws Exception
	 */
	public String findModuleFunctions() {
		try {
			moduleFunctions = functionService.findModuleFunctions();
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

}
