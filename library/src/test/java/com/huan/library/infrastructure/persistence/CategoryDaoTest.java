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
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testImportCategorysFromExcel(){
		List<Category> categorys = new ArrayList<Category>(); 
		//ȡ��excel�ļ�
        File file = new File(filePath);
        Long begin = null;
        Long end = null;
        Workbook wb;   
        begin = System.currentTimeMillis();
        System.out.println("��ʼʱ��"+System.currentTimeMillis());
       
        try {
        	//��workbook
            wb = Workbook.getWorkbook(file);  
            //�򿨵�һ��sheet
            Sheet sheet = wb.getSheet(0);   
            //ȡ������
            int row = sheet.getRows();   
            //ȡ������
            int col = sheet.getColumns(); 
            //ȡ��һ����ÿ�е�ֵ��ֵ��һ��Category�����Ӧ�����ԣ�ֱ�����һ��
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
            
            //��������Category
            try {
    			categoryDao.insertCategorysBatch(categorys);
    			end = 	System.currentTimeMillis();
    			System.out.println("����ʱ��"+System.currentTimeMillis());
    			System.out.println(begin-end);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
	}

}
