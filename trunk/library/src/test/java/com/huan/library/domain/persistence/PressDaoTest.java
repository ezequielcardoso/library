package com.huan.library.domain.persistence;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.infrastructure.persistence.PressDao;

public class PressDaoTest {

	private static PressDao pressDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	  pressDao = (PressDao)BaseSpringBeans.getInstance().getBean("pressDao");
	}
	
	@Test
	public void testAdd(){
		try {
			pressDao.selectMaxTs();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
