package com.huan.library.infrastructure.persistence;


import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.dict.Resource;
/**
 * Êý¾Ý×Öµädao²âÊÔ
 * @author huan
 * @time  2011-3-13 ÏÂÎç07:50:41
 */
public class DictItemDaoTest {

	private static DictItemDao dictItemDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dictItemDao = (DictItemDao)BaseSpringBeans.getInstance().getBean("dictItemDao");
	}
  
	@Test
	public void testAdd(){
		
		Resource resource = new Resource();
		resource.setShortName("¹ºÂò");
		
		try {
			dictItemDao.saveOrUpdate(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
