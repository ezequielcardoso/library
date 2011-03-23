package com.huan.library.infrastructure.persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.dict.Certificate;

/**
 * 证件 如:学生证/身份证/驾驶本  补证时别用
 * @author huan
 * @time 2011-3-16 下午02:12:25
 */
public class CertificateInitTest {

	private static DictItemDao dictItemDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dictItemDao = (DictItemDao) BaseSpringBeans.getInstance().getBean(
				"dictItemDao");
	}
	
	@Test
	public void testCertificateInit(){
		try{
			Certificate certificate = new Certificate();
			certificate.setShortName("学生证");
			certificate.setItemCode("Certificate");
			dictItemDao.saveOrUpdate(certificate);
			
			Certificate certificate2 = new Certificate();
			certificate2.setShortName("身份证");
			certificate2.setItemCode("Certificate2");
			dictItemDao.saveOrUpdate(certificate2);
			
			Certificate certificate3 = new Certificate();
			certificate3.setShortName("驾驶本");
			certificate3.setItemCode("Certificate3");
			dictItemDao.saveOrUpdate(certificate3);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
