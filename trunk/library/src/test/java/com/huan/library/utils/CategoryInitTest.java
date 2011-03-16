package com.huan.library.utils;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.book.Category;
import com.huan.library.infrastructure.persistence.CategoryDao;

public class CategoryInitTest {

	private static String filePath = "f:\\test.xls";
	 String categoryId = null;
     String categoryCode = null;
     String categoryName = null;
     String parentCateId = null;
	
	private static CategoryDao categoryDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		categoryDao = (CategoryDao)BaseSpringBeans.getInstance().getBean("categoryDao");
	}
   
	/**
	 * 查询分类测试
	 */
	//@Test
	public void testSelect(){
		List<Category> categorys = new ArrayList<Category>();
		try {
			categorys = categoryDao.selectAllCategorys();
			for(Category category:categorys){
				System.out.println(category.getCategoryId());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@Test  //添加根节点
	public void testInsertRoot(){
		Category category = new Category();
		category.setCategoryId("ROOT");
		category.setCategoryCode("ROOT");
		category.setCategoryName("中图法");
		
		category.setParent(null);
		
		try {
			categoryDao.saveOrUpdate(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 添加其他的
	 */
	@Test
	public void testCategorys() {

		List<Category> categorys = new ArrayList<Category>();
		try {
			// 文件流指向excel文件
			FileInputStream fin = new FileInputStream(filePath);
			HSSFWorkbook workbook = new HSSFWorkbook(fin);// 创建工作薄
			HSSFSheet sheet = workbook.getSheetAt(0);// 得到工作表
			HSSFRow row = null;// 对应excel的行
			HSSFCell cell = null;// 对应excel的列
          
           int totalRow = sheet.getLastRowNum();// 得到excel的总记录条数
          
			for (int i = 1; i <=totalRow; i++) {
				Category category = new Category();
				row = sheet.getRow(i);
				cell = row.getCell(0);
				categoryId = cell.getRichStringCellValue().toString();
				cell = row.getCell(1);
				categoryCode = cell.getRichStringCellValue().toString();
				cell=row.getCell(2);   
				categoryName=cell.getRichStringCellValue().toString();
				cell=row.getCell(3);   
				parentCateId=cell.getRichStringCellValue().toString();
				category.setCategoryId(categoryId);
				category.setCategoryName(categoryName);
				category.setCategoryCode(categoryCode);
				Category categoryParent = categoryDao.get(parentCateId);
				category.setParent(categoryParent);
				
				categoryDao.saveOrUpdate(category);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
}
