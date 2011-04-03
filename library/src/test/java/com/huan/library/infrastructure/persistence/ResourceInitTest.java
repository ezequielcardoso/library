package com.huan.library.infrastructure.persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.dict.Source;

/**
 * ͼ����Դ��ʼ�� ����/����
 * @author Administrator
 * @time  2011-3-16 ����02:24:30
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
				Source resource = new Source();
				resource.setItemName("����");
				resource.setItemCode("Resource");
				dictItemDao.saveOrUpdate(resource);
				
				Source resource2 = new Source();
				resource2.setItemName("����");
				resource2.setItemCode("Resource2");
				dictItemDao.saveOrUpdate(resource2);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
}
