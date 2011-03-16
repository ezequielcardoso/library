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
			// �ļ���ָ��excel�ļ�
			FileInputStream fin = new FileInputStream(filePath);
			HSSFWorkbook workbook = new HSSFWorkbook(fin);// ����������
			HSSFSheet sheet = workbook.getSheetAt(0);// �õ�������
			HSSFRow row = null;// ��Ӧexcel����
			HSSFCell cell = null;// ��Ӧexcel����

			int totalRow = sheet.getLastRowNum();// �õ�excel���ܼ�¼����
			// ���µ��ֶ�һһ��Ӧ���ݿ����ֶ�
			String categoryId = "";
			String categoryCode = "";
			String categoryName = "";
			String parentCateId = "";

			String sql = "insert into t_stu(categoryId,categoryCode,categoryName,parentCateId) "
					+ "values(?,?,?,?)"; // SEQ_BOOK.NEXTVALΪ���ݿ������

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
