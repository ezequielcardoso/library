package com.huan.library.infrastructure.persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.dict.BookLevel;
/**
 * 图书级别
 * @author Administrator
 * @time  2011-3-23 上午10:53:32
 */
public class BookLevelTest {

	private static DictItemDao dictItemDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dictItemDao = (DictItemDao) BaseSpringBeans.getInstance().getBean(
				"dictItemDao");
	}

	@Test
	public void testAdd() {
		try {
			BookLevel bookLevel = new BookLevel();
			bookLevel.setShortName("普通");
			bookLevel.setItemCode("BookLevel");
			dictItemDao.saveOrUpdate(bookLevel);

			BookLevel bookLevel2 = new BookLevel();
			bookLevel2.setShortName("高级");
			bookLevel2.setItemCode("BookLevel2");
			dictItemDao.saveOrUpdate(bookLevel2);

			BookLevel bookLevel3 = new BookLevel();
			bookLevel3.setShortName("高级图书");
			bookLevel3.setItemCode("BookLevel3");
			dictItemDao.saveOrUpdate(bookLevel3);
			
			BookLevel bookLevel4 = new BookLevel();
			bookLevel4.setShortName("秘密");
			bookLevel4.setItemCode("BookLevel4");
			dictItemDao.saveOrUpdate(bookLevel4);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
