package com.huan.libray.application.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


/**
 * 实现BeanPostProcessor接口，可以实现在Spring加载时，
 * 调取一个的对象的方法，使其能够取得实例化以后的Service.
 * 
 */
public class SystemBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessAfterInitialization(Object obj, String s) throws BeansException {
		if (obj instanceof BorrowReturnService) {
			Timer timer = new Timer();
			
			//启动定时器计划任务
		}
		return obj;
	}

	public Object postProcessBeforeInitialization(Object obj, String s)
			throws BeansException {
		return obj;
	}
}