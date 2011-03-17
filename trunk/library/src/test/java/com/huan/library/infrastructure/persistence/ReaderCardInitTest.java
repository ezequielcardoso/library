package com.huan.library.infrastructure.persistence;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.reader.ReaderCard;
import com.huan.library.util.Constants;

/**
 * 借阅证初始化
 * 
 * @author huan
 * @time 2011-3-17 下午07:26:04
 */
public class ReaderCardInitTest {

	private static ReaderCardDao readerCardDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		readerCardDao = (ReaderCardDao) BaseSpringBeans.getInstance().getBean(
				"readerCardDao");
	}

	@Test
	public void testReaderCardInit() {
		try {
			ReaderCard readerCard = new ReaderCard();
			readerCard.setBarCode("0803010099");
			readerCard.setReaderCardCode("0803010099");
			readerCard.setPassword("0803010099");
			readerCard.setReader(null);
			readerCard.setEntyDate(new Date(2008 - 2 - 2));
			readerCard.setEffectiveDate(new Date(2012 - 2 - 2));
			readerCard.setCardState(Constants.COMMON);

			readerCardDao.saveOrUpdate(readerCard);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
