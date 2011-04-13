package com.huan.library.infrastructure.persistence;


import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.util.DateFormatUtil;

public class DateTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	
	@Test
	public void testDate(){
		
		Date today = new Date();
		Date last = new Date(2011-4-12);
		
		long different = today.getTime() - last.getTime();
		
		System.out.println(different/(3600*24*1000));
		
	}
}
