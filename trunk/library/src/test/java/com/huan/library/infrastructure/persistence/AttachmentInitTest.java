package com.huan.library.infrastructure.persistence;


import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.dict.Attachment;
import com.huan.library.domain.model.dict.DictItem;
/**
 * ��������dvd/vcd/cd/src...��ʼ��
 * @author huan
 * @time  2011-3-16 ����01:41:38
 */
public class AttachmentInitTest {

	private static DictItemDao dictItemDao; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dictItemDao = (DictItemDao)BaseSpringBeans.getInstance().getBean("dictItemDao");
	}
	/**
	 * ��ʼ��
	 */
	@Test
	public void testInit(){
		try{
		Attachment attachment1 = new Attachment();
		attachment1.setShortName("����");
		dictItemDao.saveOrUpdate(attachment1);
		
		Attachment attachment2 = new Attachment();
		attachment2.setShortName("��Ƭ");
		dictItemDao.saveOrUpdate(attachment2);
		
		Attachment attachment3 = new Attachment();
		attachment3.setShortName("dvd");
		dictItemDao.saveOrUpdate(attachment3);
		
		Attachment attachment4 = new Attachment();
		attachment4.setShortName("src");
		dictItemDao.saveOrUpdate(attachment4);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testFind(){
		List<DictItem> dictItems = new ArrayList<DictItem>();
		try {
			dictItems = dictItemDao.selectAllDictItems();
			for(DictItem dictItem:dictItems){
			  System.out.println(dictItem.getItemId()+" "+dictItem.getShortName());
			}
		} catch (Exception e) {
	      e.printStackTrace();
		}
	}

}
