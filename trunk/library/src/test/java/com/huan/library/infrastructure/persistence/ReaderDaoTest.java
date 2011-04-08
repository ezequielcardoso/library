package com.huan.library.infrastructure.persistence;


import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.reader.Certificate;
import com.huan.library.domain.model.reader.Reader;
import com.huan.library.domain.model.reader.ReaderType;
/**
 * 读者dao测试
 * @author huan
 * @time 2011-3-15 上午11:19:24
 */
public class ReaderDaoTest {

	private static ReaderDao readerDao;
	private static ReaderTypeDao readerTypeDao;
	private static DictItemDao dictItemDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		readerDao = (ReaderDao)BaseSpringBeans.getInstance().getBean("readerDao");
		readerTypeDao = (ReaderTypeDao)BaseSpringBeans.getInstance().getBean("readerTypeDao");
		dictItemDao = (DictItemDao)BaseSpringBeans.getInstance().getBean("dictItemDao");
	}
	
	@Test
	public void testAddReader(){
		try{
		Reader reader = new Reader();
		reader.setReaderName("lily");
		reader.setBirthday(new Date(1999-2-2));
		
		//有效有效证件
		Certificate certificate = new Certificate();
		certificate.setItemName("学生正");
		dictItemDao.saveOrUpdate(certificate);
		reader.setCertificate(certificate);
		
		//分类
		ReaderType readerType = new ReaderType();
		readerType.setReaderCateName("教师");
		readerType.setReaderCateCode("s002");
		readerType.setBorrowDays(15);
		readerType.setBorrowedQuantity(5);
		readerType.setRent(0.5f);
		readerTypeDao.saveOrUpdate(readerType);
		reader.setReaderType(readerType);
		
		readerDao.saveOrUpdate(reader);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
