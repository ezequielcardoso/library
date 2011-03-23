package com.huan.library.infrastructure.persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.dict.BookLevel;
/**
 * ͼ�鼶��
 * @author Administrator
 * @time  2011-3-23 ����10:53:32
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
			bookLevel.setShortName("��ͨ");
			bookLevel.setItemCode("BookLevel");
			dictItemDao.saveOrUpdate(bookLevel);

			BookLevel bookLevel2 = new BookLevel();
			bookLevel2.setShortName("�߼�");
			bookLevel2.setItemCode("BookLevel2");
			dictItemDao.saveOrUpdate(bookLevel2);

			BookLevel bookLevel3 = new BookLevel();
			bookLevel3.setShortName("�߼�ͼ��");
			bookLevel3.setItemCode("BookLevel3");
			dictItemDao.saveOrUpdate(bookLevel3);
			
			BookLevel bookLevel4 = new BookLevel();
			bookLevel4.setShortName("����");
			bookLevel4.setItemCode("BookLevel4");
			dictItemDao.saveOrUpdate(bookLevel4);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
