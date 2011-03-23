package com.huan.library.infrastructure.persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.dict.BookState;

/**
 * ͼ��״̬ ������/ԤԼ��/������/������/�ڹ�
 * @author Administrator
 * @time  2011-3-16 ����03:30:23
 */
public class BookStateInitTest {
	 
	    private static DictItemDao dictItemDao; 
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			dictItemDao = (DictItemDao)BaseSpringBeans.getInstance().getBean("dictItemDao");
		}
		@Test
		public void testStateInit(){
			try{
				BookState bookState = new BookState();
				bookState.setShortName("������");
				bookState.setItemCode("BookState");
				dictItemDao.saveOrUpdate(bookState);
				
				BookState bookState2 = new BookState();
				bookState2.setShortName("ԤԼ��");
				bookState2.setItemCode("BookStat2");
				dictItemDao.saveOrUpdate(bookState2);
			
				BookState bookState3 = new BookState();
				bookState3.setShortName("������");
				bookState3.setItemCode("BookState3");
				dictItemDao.saveOrUpdate(bookState3);
			
				BookState bookState4 = new BookState();
				bookState4.setShortName("������");
				bookState4.setItemCode("BookState4");
				dictItemDao.saveOrUpdate(bookState4);
				
				BookState bookState5 = new BookState();
				bookState5.setShortName("�ڹ�");
				bookState5.setItemCode("BookState5");
				dictItemDao.saveOrUpdate(bookState5);
			
			}catch(Exception e){
				e.printStackTrace();
			}
		}
}
