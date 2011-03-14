package com.huan.library.infrastructure.persistence;


import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.book.Category;

public class CategoryDaoTest {

	private static CategoryDao categoryDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		categoryDao=(CategoryDao)BaseSpringBeans.getInstance().getBean("categoryDao");
	}
	
	@Test
	public void testAddCategory(){
	    
		//��ӵ�һ���ڵ�
		/*  Category rootCategory = new Category();
	        rootCategory.setCategoryId("0");
	        rootCategory.setCategoryCode("0");
	        rootCategory.setCategoryName("��ͼ��");
	        rootCategory.setParent(null);
	        
	        try {
				categoryDao.saveOrUpdate(rootCategory);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		
		//     ��ӵڶ���		
		Category category = new Category();
		category.setCategoryId("A");
		category.setCategoryCode("A");
		category.setCategoryName("���˼���塢�������塢ë��˼�롢��Сƽ����");
		Category parentCategory = new Category();
		parentCategory.setCategoryId("0");
		category.setParent(parentCategory);
		try {
			categoryDao.saveOrUpdate(category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
