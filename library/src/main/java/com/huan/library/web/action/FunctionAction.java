package com.huan.library.web.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
	
	@Autowired
	private FunctionService functionService ;
	
	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}

	/**
	 * 查找系统模块功能
	 * @return
	 * @throws Exception
	 */
	public String findModuleFunctions() {
		try {
	//		request.setAttribute("moduleFunctions", functionService.findModuleFunctions());
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

}
