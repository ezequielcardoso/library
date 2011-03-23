package com.huan.library.infrastructure.persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.dict.Resource;

/**
 * 图书来源初始化 捐赠/购买
 * @author Administrator
 * @time  2011-3-16 下午02:24:30
 */
public class ResourceInitTest {
	 
	    private static DictItemDao dictItemDao; 
		
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			dictItemDao = (DictItemDao)BaseSpringBeans.getInstance().getBean("dictItemDao");
		}
		
		@Test
		public void testResourceInit(){
			try{
				Resource resource = new Resource();
				resource.setShortName("购买");
				resource.setItemCode("Resource");
				dictItemDao.saveOrUpdate(resource);
				
				Resource resource2 = new Resource();
				resource2.setShortName("捐赠");
				resource2.setItemCode("Resource2");
				dictItemDao.saveOrUpdate(resource2);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
}
