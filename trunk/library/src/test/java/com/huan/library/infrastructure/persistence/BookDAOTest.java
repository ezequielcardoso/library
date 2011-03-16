package com.huan.library.infrastructure.persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.book.Category;
import com.huan.library.domain.model.book.Press;
import com.huan.library.domain.model.dict.Attachment;
import com.huan.library.domain.model.dict.BookLevel;
import com.huan.library.domain.model.dict.Currency;
import com.huan.library.domain.model.dict.Resource;
import com.huan.library.infrastructure.persistence.PressDao;
/**
 * 图书dao测试类
 * @author huan
 * @time  2011-3-11 下午01:57:59
 */
public class BookDAOTest {

	private static BookDao bookDao ;
    private static DictItemDao dictItemDao;
    private static PressDao pressDao;
	private  static CategoryDao categoryDao;
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	  bookDao = (BookDao) BaseSpringBeans.getInstance().getBean("bookDao");
	  dictItemDao = (DictItemDao)BaseSpringBeans.getInstance().getBean("dictItemDao");
	  pressDao = (PressDao)BaseSpringBeans.getInstance().getBean("pressDao");
	  categoryDao= (CategoryDao)BaseSpringBeans.getInstance().getBean("categoryDao");
	}
    
	@Test public void testAdd(){
		try{
		Book book = new Book();
		book.setBookName("高等数学");
		book.setBookNo("abc-222");
		book.setBarCode("xx--222");
	    book.setSearchBookId("m2");
	    book.setSpeciesId("a21");
	    book.setAllStage("xxxxxxxxxxx");
	    
	    //附件
	    Attachment attachment = new Attachment();
	    attachment.setShortName("DVD");
	    dictItemDao.saveOrUpdate(attachment);
	    book.setAttachment(attachment);
	    
	    //出版社
		Press press = new Press();
		press.setPressAddress("大连");
		press.setZipCode("18612");
		pressDao.saveOrUpdate(press);
		book.setPress(press);
		
		//图书分类
		Category category = new Category();
		category.setCategoryCode("B");
		category.setCategoryId("B");
		category.setCategoryName("数学");
		category.setParent(null);
		categoryDao.saveOrUpdate(category);
		book.setBookCategory(category);
		
		//图书级别
		BookLevel bookLevel = new BookLevel();
		bookLevel.setShortName("密级");
	    dictItemDao.saveOrUpdate(bookLevel);
		book.setBookLevel(bookLevel);
	    
	    //来源
	    Resource resource = new Resource();
	    resource.setShortName("捐赠");
	    dictItemDao.saveOrUpdate(resource);
	    book.setResource(resource);
	    
	    //币种
	    Currency currency = new Currency();
	    currency.setShortName("人名币");
	    dictItemDao.saveOrUpdate(currency);
	    book.setCurrency(currency);
	    
  
		bookDao.saveOrUpdate(book);

		}catch (Exception e) {
		  e.printStackTrace();
		}
	}
	
	
	
}
