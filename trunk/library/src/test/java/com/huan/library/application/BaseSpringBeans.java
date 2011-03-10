package com.huan.library.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.util.Assert;

public class BaseSpringBeans {
	
	private ApplicationContext applicationContext;
	
	private static BaseSpringBeans instance = null;   
	
	private BaseSpringBeans() {    
		try {
			this.setUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}   
	
	public static BaseSpringBeans getInstance() {    
		if(instance == null) {    
			instance = new BaseSpringBeans();    
		}   
		return instance;    
	}    
	
	private void setUp() throws Exception {
		applicationContext = new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/applicationContext.xml");
		Assert.notNull(applicationContext,"»›∆˜º”‘ÿ ß∞‹@");
	}

	
	private void tearDown() throws Exception {
		applicationContext = null;
	}

	public Object getBean(String name){
		return applicationContext.getBean(name);
	}
	
	public static void main(String args[]){
		BaseSpringBeans beans = new BaseSpringBeans();
		try {
			System.out.println(beans.getBean("bookDao"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
