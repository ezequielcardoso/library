package com.huan.library.infrastructure.persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.dict.Certificate;

/**
 * ֤�� ��:ѧ��֤/���֤/��ʻ��  ��֤ʱ����
 * @author huan
 * @time 2011-3-16 ����02:12:25
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
			certificate.setItemName("ѧ��֤");
			certificate.setItemCode("Certificate");
			dictItemDao.saveOrUpdate(certificate);
			
			Certificate certificate2 = new Certificate();
			certificate2.setItemName("���֤");
			certificate2.setItemCode("Certificate2");
			dictItemDao.saveOrUpdate(certificate2);
			
			Certificate certificate3 = new Certificate();
			certificate3.setItemName("��ʻ��");
			certificate3.setItemCode("Certificate3");
			dictItemDao.saveOrUpdate(certificate3);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
