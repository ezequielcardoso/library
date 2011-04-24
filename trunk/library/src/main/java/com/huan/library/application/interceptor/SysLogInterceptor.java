package com.huan.library.application.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.huan.library.domain.model.SysLog;
import com.huan.library.domain.model.rights.User;
import com.huan.library.domain.service.SysLogService;
import com.huan.library.util.DateFormatUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 日志拦截器
 * @author Administrator
 *
 */
public class SysLogInterceptor extends AbstractInterceptor {
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		try{
			String str = invocation.invoke();
			if(invocation.isExecuted()){
				ActionContext ctx = invocation.getInvocationContext();
				HttpServletRequest request = (HttpServletRequest) ctx
						.get(ServletActionContext.HTTP_REQUEST);
				HttpSession session = request.getSession();
				SysLog sysLog = new SysLog();
		        sysLog.setOperator(((User)session.getAttribute("currUser")).getUserName());
		        sysLog.setOperateDate(new Date());
		        sysLog.setOperateIPAddress(request.getRemoteAddr());
		        sysLog.setOperateType((String)request.getAttribute("operateType"));
				sysLog.setFuncName((String)request.getAttribute("funcName"));
				sysLog.setOperateDescription(((User)session.getAttribute("currUser")).getUserName() + " 在 " + 
						DateFormatUtil.format(new Date(), "yyyy-MM-dd") + " " 
						+  request.getAttribute("operateDescription"));
				WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
				SysLogService service = (SysLogService) applicationContext.getBean("sysLogService");
				service.save(sysLog);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}


}
