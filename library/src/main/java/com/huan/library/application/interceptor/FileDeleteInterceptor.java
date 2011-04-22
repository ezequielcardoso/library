package com.huan.library.application.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.huan.library.util.FileOperate;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 文件下载后删除文件拦截器
 * @author Administrator
 *
 */
public class FileDeleteInterceptor extends AbstractInterceptor{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		try{
			invocation.invoke();
			if(invocation.isExecuted()){
				ActionContext ctx = invocation.getInvocationContext();
				HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
				FileOperate.delFile((String) request.getAttribute("deleteFileName"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}

}
