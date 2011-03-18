package com.huan.library.domain.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.huan.library.domain.model.book.Category;
/**
 * ��ͼ�������Ϣ�������ݿ�
 * @author huan
 * @time  2011-3-16 ����11:42:20
 */
public class ExcelToDB {

	private static String filePath = "f:\\test.xls";

	public static List<Category> getCategorys() {

		 List<Category> categorys = new ArrayList<Category>();
		try {
			// �ļ���ָ��excel�ļ�
			FileInputStream fin = new FileInputStream(filePath);
			HSSFWorkbook workbook = new HSSFWorkbook(fin);// ����������
			HSSFSheet sheet = workbook.getSheetAt(0);// �õ�������
			HSSFRow row = null;// ��Ӧexcel����
			HSSFCell cell = null;// ��Ӧexcel����
            String categoryId = null;
            String categoryCode = null;
            String categoryName = null;
            String parentCateId = null;
            int totalRow = sheet.getLastRowNum();// �õ�excel���ܼ�¼����
           
			for (int i = 0; i < totalRow; i++) {
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
				Category categoryParent = new Category();
				categoryParent.setCategoryId(parentCateId);
				category.setParent(categoryParent);
				
				categorys.add(category);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}	
		return categorys;
	}
}
