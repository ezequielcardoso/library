package com.huan.library.web.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.huan.library.domain.model.rights.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorizationInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception { // 确认Session中是否存在userid
		Map session = actionInvocation.getInvocationContext().getSession();
		User currentUser = (User) session.get("currentUser");
		ActionContext actionContext = actionInvocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
		if (currentUser != null) {
			// 存在的情况下进行后续操作。
			return actionInvocation.invoke();
		} else {
			// 否则终止后续操作，返回LOGIN
			System.out.println("notlogin");
			if (("XMLHttpRequest".equalsIgnoreCase(request.getHeader("x-requested-with")))
					|| ("Ext.basex".equalsIgnoreCase(request.getHeader("x-requested-with")))) {
				((HttpServletResponse) actionContext.get(StrutsStatics.HTTP_RESPONSE)).setHeader("sessionstatus", "timeout");
				return null;
			}
		}
		return "login";
	}
}
