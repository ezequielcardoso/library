package com.huan.library.infrastructure.persistence;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.Cell;
import jxl.CellType;
import jxl.LabelCell;
import jxl.Sheet;
import jxl.Workbook;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.book.Category;

public class CategoryDaoTest {

	private static CategoryDao categoryDao;
	
	private String filePath = "D:\\Workspaces\\eclipse-jee-3.5\\library\\src\\main\\webapp\\doc\\categories.xls";
//	private String filePath = "E:\\works\\myproject\\webproject\\src\\main\\webapp\\doc\\test.xls";
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		categoryDao=(CategoryDao)BaseSpringBeans.getInstance().getBean("categoryDao");
	}
	
	//@Test
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
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testImportCategorysFromExcel(){
		List<Category> categorys = new ArrayList<Category>(); 
		//取得excel文件
        File file = new File(filePath);
        Long begin = null;
        Long end = null;
        Workbook wb;   
        begin = System.currentTimeMillis();
        System.out.println("开始时间"+System.currentTimeMillis());
       
        try {
        	//打开workbook
            wb = Workbook.getWorkbook(file);  
            //打卡第一个sheet
            Sheet sheet = wb.getSheet(0);   
            //取得行数
            int row = sheet.getRows();   
            //取得列数
            int col = sheet.getColumns(); 
            //取到一行中每列的值赋值给一个Category对象对应的属性，直到最后一行
            for (int i = 0; i < row; i++) {   
            	Category category = new Category();
            	Category pcategory = new Category();
                for (int j = 0; j < col; j++) {
                    Cell cell = sheet.getCell(j, i);   
                    if (cell.getType() == CellType.LABEL) {   
                        LabelCell lc = (LabelCell) cell;   
                        switch (j) {   
                        case 0:   
                        	category.setCategoryId(lc.getContents());break;   
                        case 1:   
                        	category.setCategoryCode(lc.getContents());break;
                        case 2:
                        	category.setCategoryName(lc.getContents());break;
                        case 3: //parent
                        	pcategory.setCategoryId(lc.getContents());
                        	category.setParent(pcategory);
                        	;break;	
                        }   
                    }   
                }   
                categorys.add(category);   
            }  
            
            //批量增加Category
            try {
    			categoryDao.insertCategorysBatch(categorys);
    			end = 	System.currentTimeMillis();
    			System.out.println("结束时间"+System.currentTimeMillis());
    			System.out.println(begin-end);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
	}

}
