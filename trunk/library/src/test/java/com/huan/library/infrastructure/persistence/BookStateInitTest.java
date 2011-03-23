package com.huan.library.infrastructure.persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.dict.BookState;

/**
 * 图书状态 核审中/预约中/借阅中/逾期中/在馆
 * @author Administrator
 * @time  2011-3-16 下午03:30:23
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
				bookState.setShortName("核审中");
				bookState.setItemCode("BookState");
				dictItemDao.saveOrUpdate(bookState);
				
				BookState bookState2 = new BookState();
				bookState2.setShortName("预约中");
				bookState2.setItemCode("BookStat2");
				dictItemDao.saveOrUpdate(bookState2);
			
				BookState bookState3 = new BookState();
				bookState3.setShortName("借阅中");
				bookState3.setItemCode("BookState3");
				dictItemDao.saveOrUpdate(bookState3);
			
				BookState bookState4 = new BookState();
				bookState4.setShortName("逾期中");
				bookState4.setItemCode("BookState4");
				dictItemDao.saveOrUpdate(bookState4);
				
				BookState bookState5 = new BookState();
				bookState5.setShortName("在馆");
				bookState5.setItemCode("BookState5");
				dictItemDao.saveOrUpdate(bookState5);
			
			}catch(Exception e){
				e.printStackTrace();
			}
		}
}
