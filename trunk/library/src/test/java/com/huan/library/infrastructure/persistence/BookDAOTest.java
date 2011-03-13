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
	private static PressDao pressDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	  bookDao = (BookDao) BaseSpringBeans.getInstance().getBean("bookDao");
	  pressDao =(PressDao)BaseSpringBeans.getInstance().getBean("pressDao");
	}
    
	@Test public void testAdd() throws Exception{
		Book book = new Book();
		book.setBookNo("abc-222");
		book.setBookDesc("abc");
		
		Press press = new Press();
		press.setPressISBN("xxxx");
		press.setPressName("大连出版社");
		press.setPressAddress("大连");
		press.setZipCode("3dffds0a");
		pressDao.saveOrUpdate(press);
		
		book.setPress(press);
		
		bookDao.saveOrUpdate(book);
	}
	
	
	
}
