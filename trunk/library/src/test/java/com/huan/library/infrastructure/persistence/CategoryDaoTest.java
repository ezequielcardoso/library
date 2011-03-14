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
	    
		//添加第一个节点
		/*  Category rootCategory = new Category();
	        rootCategory.setCategoryId("0");
	        rootCategory.setCategoryCode("0");
	        rootCategory.setCategoryName("中图法");
	        rootCategory.setParent(null);
	        
	        try {
				categoryDao.saveOrUpdate(rootCategory);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		
		//     添加第二个		
		Category category = new Category();
		category.setCategoryId("A");
		category.setCategoryCode("A");
		category.setCategoryName("马克思主义、列宁主义、毛泽东思想、邓小平理论");
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
