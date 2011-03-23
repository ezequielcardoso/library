package com.huan.library.infrastructure.persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.dict.Currency;

/**
 * ���ֳ�ʼ�� �����/��Ԫ/��Ԫ
 * @author Administrator
 * @time  2011-3-16 ����02:18:11
 */
public class CurrencyInitTest {
	   
	    private static DictItemDao dictItemDao; 
		
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			dictItemDao = (DictItemDao)BaseSpringBeans.getInstance().getBean("dictItemDao");
		}
		@Test
		public void testCurrencyInit(){
			try{
				Currency currency = new Currency();
				currency.setShortName("�����");
				currency.setItemCode("Currency");
				dictItemDao.saveOrUpdate(currency);
				
				Currency currency2 = new Currency();
				currency2.setShortName("��Ԫ");
				currency2.setItemCode("Currency2");
				dictItemDao.saveOrUpdate(currency2);
				
				Currency currency3 = new Currency();
				currency3.setShortName("��Ԫ");
				currency3.setItemCode("Currency3");
				dictItemDao.saveOrUpdate(currency3);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
}
