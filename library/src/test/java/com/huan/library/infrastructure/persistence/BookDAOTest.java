package com.huan.library.infrastructure.persistence;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.huan.library.domain.model.book.Book;
/**
 * 图书dao测试类
 * @author huan
 * @time  2011-3-11 下午01:57:59
 */
public class BookDAOTest {

	private static BookDao bookDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	ApplicationContext	applicationContext = new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/applicationContext.xml");
	  bookDao = (BookDao)applicationContext.getBean("bookDao");
	}
    
	@Test public void testAdd(){
		System.out.println("hello");
		Book book = new Book();
		book.setBookNo("abc-222");
		book.setBookDesc("abc");
		bookDao.saveOrUpdateBook(book);
	}
	
	
	@Test public void testFind(){
		
		System.out.println("1111111111111111111111111");
		
		Book book = bookDao.selectBookById(String.valueOf(2));
		
		System.out.println(book.getBookDesc());
		
		System.out.println("1111111111111111111111111");
	}
	
}
