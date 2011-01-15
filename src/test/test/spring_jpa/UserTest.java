package test.spring_jpa;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huan009.library.domain.Book;
import com.huan009.library.service.BookService;

public class UserTest {

	private static  ApplicationContext ac =  null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	 
		ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testAdd(){
		
		BookService bookService = (BookService)ac.getBean("bookServiceBean");
		Book book =  new Book();
		bookService.save(book);
	}

}
