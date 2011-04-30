package com.huan.library.application.processor;

import java.util.List;
import java.util.Timer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.huan.library.domain.model.borrowReturn.BorrowReturn;
import com.huan.library.domain.service.BorrowReturnService;
import com.huan.library.email.SendMailToSomeone;
import com.huan.library.web.action.BaseActionSupport;


/**
 * 实现BeanPostProcessor接口，可以实现在Spring加载时，
 * 调取一个的对象的方法，使其能够取得实例化以后的Service.
 * 
 */
public class SystemBeanPostProcessor extends BaseActionSupport implements BeanPostProcessor {

	public Object postProcessAfterInitialization(Object obj, String s) throws BeansException {
		if (obj instanceof BorrowReturnService) {
			Timer timer = new Timer();
			timer.schedule(new MyTask(), 1000, 10 * 1000);// 在1秒后执行此任务,每次间隔2秒,如果传递一个Data参数,就可以在某个固定的时间执行这个任务.
			
			//启动定时器计划任务
		}
		return obj;
	}

	public Object postProcessBeforeInitialization(Object obj, String s)
			throws BeansException {
		return obj;
	}
	
	public HttpServletRequest getRequest(){
		return super.request; 
	}
	
	class MyTask extends java.util.TimerTask {

		SendMailToSomeone sts = new SendMailToSomeone();

		@Override
		public void run() {
			WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getRequest().getSession().getServletContext());
			BorrowReturnService borrowReturnService = (BorrowReturnService) ctx.getBean("borrowReturnService");

			
			List<BorrowReturn> borrowReturns = borrowReturnService
					.aboutToDueBorrowReturns();
			for (BorrowReturn borrowReturn : borrowReturns) {
				sts.send("aa", "hello", borrowReturn.getReader().getEmail(),
						"jacksnh@163.com", "huan10011099", "smtp.163.com");
			}
		}
	}
}