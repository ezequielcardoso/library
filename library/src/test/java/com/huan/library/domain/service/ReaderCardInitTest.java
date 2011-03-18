package com.huan.library.domain.service;


import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.infrastructure.persistence.ReaderCardDao;

public class ReaderCardInitTest {

	private static ReaderCardDao readerCardDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		readerCardDao = (ReaderCardDao)BaseSpringBeans.getInstance().getBean("readerCardDao");
	}
	
	@Test
	public void testInit(){
		
	}

}
