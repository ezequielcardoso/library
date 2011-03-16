package com.huan.library.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelToDB {

	private Connection con;
	private DBConnection db;
	private PreparedStatement pst;
	private String filePath = "f:\\test.xls";

	public void insertDB() {

		db = new DBConnection();
		con = db.getConnection();
		
		try {
			// 文件流指向excel文件
			FileInputStream fin = new FileInputStream(filePath);
			HSSFWorkbook workbook = new HSSFWorkbook(fin);// 创建工作薄
			HSSFSheet sheet = workbook.getSheetAt(0);// 得到工作表
			HSSFRow row = null;// 对应excel的行
			HSSFCell cell = null;// 对应excel的列

			int totalRow = sheet.getLastRowNum();// 得到excel的总记录条数
			// 以下的字段一一对应数据库表的字段
			String categoryId = "";
			String categoryCode = "";
			String categoryName = "";
			String parentCateId = "";

			String sql = "insert into t_stu(categoryId,categoryCode,categoryName,parentCateId) "
					+ "values(?,?,?,?)"; // SEQ_BOOK.NEXTVAL为数据库表序列

			for (int i = 0; i <= totalRow; i++) {
				row = sheet.getRow(i);
				cell = row.getCell(0);
				categoryId = cell.getRichStringCellValue().toString();
				cell = row.getCell(1);
				categoryCode = cell.getRichStringCellValue().toString();
				cell=row.getCell(2);   
				categoryName=cell.getRichStringCellValue().toString();
				cell=row.getCell(3);   
				parentCateId=cell.getRichStringCellValue().toString();
				
				pst = con.prepareStatement(sql);
				pst.setString(1, categoryId);
				pst.setString(2, categoryCode);
				pst.setString(3, categoryName);
				pst.setString(4, parentCateId);
				

				pst.execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public static void main(String args[]) {
		ExcelToDB toDB = new ExcelToDB();
		toDB.insertDB();
	}

}
