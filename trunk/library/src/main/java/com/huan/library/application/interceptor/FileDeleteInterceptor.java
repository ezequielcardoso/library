package com.huan.library.application.interceptor;

import com.huan.library.util.FileOperate;
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
				String deleteFileName = (String) invocation.getInvocationContext().getSession().get("deleteFileName");
				FileOperate.delFile(deleteFileName);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}

}
