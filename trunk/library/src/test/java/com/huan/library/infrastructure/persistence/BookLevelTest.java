package com.huan.library.infrastructure.persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.dict.BookLevel;

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
			bookLevel.setShortName("��ͨ");
			dictItemDao.saveOrUpdate(bookLevel);

			BookLevel bookLevel2 = new BookLevel();
			bookLevel2.setShortName("�߼�");
			dictItemDao.saveOrUpdate(bookLevel2);

			BookLevel bookLevel3 = new BookLevel();
			bookLevel3.setShortName("�߼�ͼ��");
			dictItemDao.saveOrUpdate(bookLevel3);
			
			BookLevel bookLevel4 = new BookLevel();
			bookLevel4.setShortName("����");
			dictItemDao.saveOrUpdate(bookLevel4);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
