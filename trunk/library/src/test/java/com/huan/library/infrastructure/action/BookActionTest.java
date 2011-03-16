package com.huan.library.infrastructure.action;


import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.web.action.BookAction;
/**
 * Õº Èaction≤‚ ‘
 * @author huan
 * @author 2011-3-15 œ¬ŒÁ03:57:36
 */
public class BookActionTest {

    private static BookAction bookAction;
    
    @BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bookAction = (BookAction)BaseSpringBeans.getInstance().getBean("bookAction");
	}
	@Test
	public void testAddBook(){
	 	
	} 

}
