package com.huan.library.infrastructure.persistence;


import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.dict.Security;
/**
 * ͼ���ܼ���ʼ�� /����/���//����/
 * @author huan
 * @time  2011-3-16 ����02:03:53
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
			security.setShortName("����");
			dictItemDao.saveOrUpdate(security);
			
			Security security2 = new Security();
			security2.setShortName("���");
			dictItemDao.saveOrUpdate(security2);
			
			Security security3 = new Security();
			security3.setShortName("����");
			dictItemDao.saveOrUpdate(security3);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
