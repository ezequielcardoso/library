package com.huan.library.infrastructure.persistence;


import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.book.Press;
/**
 * 图书dao测试类
 * @author huan
 * @time  2011-3-11 下午01:57:59
 */
public class BookDAOTest {

	private static BookDao bookDao ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	  bookDao = (BookDao) BaseSpringBeans.getInstance().getBean("bookDao");
	}
    
	@Test public void testAdd(){
	  Book book = new Book();
	  book.setBookNo("st001");  //图书编号
	  book.setBookName("高等数学"); 
	  book.setBarCode("st-fdsa-3");
	  book.setSearchBookId("math011");
	  
	  //出版社
	  Press press = new Press();
	  press.setPressName("大连出版社");
	}
	
	
	@Test public void testFind(){
		
    }
	
}
