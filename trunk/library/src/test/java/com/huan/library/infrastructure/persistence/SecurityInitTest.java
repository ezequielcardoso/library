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
			security.setItemName("保留");
			security.setItemCode("Security");
			dictItemDao.saveOrUpdate(security);
			
			Security security2 = new Security();
			security2.setItemName("浏览");
			security2.setItemCode("Security2");
			dictItemDao.saveOrUpdate(security2);
			
			Security security3 = new Security();
			security3.setItemName("公开");
			security3.setItemCode("Security3");
			dictItemDao.saveOrUpdate(security3);
			
			Security security4 = new Security();
			security4.setItemName("公开");
			security4.setItemCode("Security4");
			dictItemDao.saveOrUpdate(security4);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
