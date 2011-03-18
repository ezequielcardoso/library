package com.huan.library.infrastructure.persistence;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.reader.Reader;
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
	private static ReaderDao readerDao;

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
			readerCard.setReaderPic("0803010099");
			readerCard.setReaderCardDesc("");

			readerCardDao.saveOrUpdate(readerCard);
			
			ReaderCard readerCard2 = new ReaderCard();
			readerCard2.setBarCode("0803010089");
			readerCard2.setReaderCardCode("0803010089");
			readerCard2.setPassword("0803010089");
			readerCard2.setReader(null);
			readerCard2.setEntyDate(new Date(2008 - 2 - 2));
			readerCard2.setEffectiveDate(new Date(2012 - 2 - 2));
			readerCard2.setCardState(Constants.COMMON);
			readerCard2.setReaderPic("0803010099");
			readerCard2.setReaderCardDesc("");

			readerCardDao.saveOrUpdate(readerCard2);
			
			ReaderCard readerCard3 = new ReaderCard();
			readerCard3.setBarCode("0803010078");
			readerCard3.setReaderCardCode("0803010078");
			readerCard3.setPassword("0803010078");
			
			
			Reader reader = new Reader();
			reader.setReaderName("huan");
			readerDao.saveOrUpdate(reader);
			
			readerCard3.setReader(reader);
			readerCard3.setEntyDate(new Date(2008 - 2 - 2));
			readerCard3.setEffectiveDate(new Date(2012 - 2 - 2));
			readerCard3.setCardState(Constants.LOST);
			readerCard3.setReaderPic("0803010099");
			readerCard3.setReaderCardDesc("");

			readerCardDao.saveOrUpdate(readerCard3);
			
			ReaderCard readerCard4 = new ReaderCard();
			readerCard4.setBarCode("0803010099");
			readerCard4.setReaderCardCode("0803010099");
			readerCard4.setPassword("0803010099");
			

			Reader reader4 = new Reader();
			reader4.setReaderName("huan");
			readerDao.saveOrUpdate(reader4);
			
			readerCard3.setReader(reader4);
			
			readerCard4.setReader(null);
			readerCard4.setEntyDate(new Date(2008 - 2 - 2));
			readerCard4.setEffectiveDate(new Date(2012 - 2 - 2));
			readerCard4.setCardState(Constants.OVERLIMIT);
			readerCard4.setReaderPic("0803010099");
			readerCard4.setReaderCardDesc("");

			readerCardDao.saveOrUpdate(readerCard4);
			
			ReaderCard readerCard5 = new ReaderCard();
			readerCard5.setBarCode("0803010099");
			readerCard5.setReaderCardCode("0803010099");
			readerCard5.setPassword("0803010099");
			

			Reader reader5 = new Reader();
			reader5.setReaderName("huan");
			readerDao.saveOrUpdate(reader5);
			
			readerCard3.setReader(reader5);
			readerCard5.setReader(null);
			readerCard5.setEntyDate(new Date(2008 - 2 - 2));
			readerCard5.setEffectiveDate(new Date(2012 - 2 - 2));
			readerCard5.setCardState(Constants.COMMON);
			readerCard5.setReaderPic("0803010099");
			readerCard5.setReaderCardDesc("");

			readerCardDao.saveOrUpdate(readerCard5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
