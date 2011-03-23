package com.huan.library.infrastructure.persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.dict.Currency;

/**
 * 币种初始化 人民币/美元/日元
 * @author Administrator
 * @time  2011-3-16 下午02:18:11
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
				currency.setShortName("人民币");
				currency.setItemCode("Currency");
				dictItemDao.saveOrUpdate(currency);
				
				Currency currency2 = new Currency();
				currency2.setShortName("美元");
				currency2.setItemCode("Currency2");
				dictItemDao.saveOrUpdate(currency2);
				
				Currency currency3 = new Currency();
				currency3.setShortName("日元");
				currency3.setItemCode("Currency3");
				dictItemDao.saveOrUpdate(currency3);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
}
