package com.huan.library.domain.service;


import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;

/**
 * 
 * @author huan
 * @time  2011-3-16 ÏÂÎç03:42:51
 */
public class FunctionServiceTest {
   
    private static FunctionService functionService;
    
    @BeforeClass
	public static void setUpBeforeClass() throws Exception {
    	functionService = (FunctionService)BaseSpringBeans.getInstance().getBean("functionService");
	}
   
    @Test 
    public void testFindModules(){
    	try {
//    		functionService.findModules();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}
