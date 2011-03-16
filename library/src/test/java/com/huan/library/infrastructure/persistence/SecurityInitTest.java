package com.huan.library.infrastructure.persistence;


import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.dict.Security;
/**
 * 图书密级初始化 /保留/浏览//公开/
 * @author huan
 * @time  2011-3-16 上午02:03:53
 */
public class SecurityInitTest {

    private static DictItemDao dictItemDao; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dictItemDao = (DictItemDao)BaseSpringBeans.getInstance().getBean("dictItemDao");
	}
	
	@Test
	public void testBookLevelInit(){
		try{
			Security security = new Security();
			security.setShortName("保留");
			dictItemDao.saveOrUpdate(security);
			
			Security security2 = new Security();
			security2.setShortName("浏览");
			dictItemDao.saveOrUpdate(security2);
			
			Security security3 = new Security();
			security3.setShortName("公开");
			dictItemDao.saveOrUpdate(security3);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
