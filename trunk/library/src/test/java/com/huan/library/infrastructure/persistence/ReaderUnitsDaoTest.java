package com.huan.library.infrastructure.persistence;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.CellType;
import jxl.LabelCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.reader.ReaderUnits;

public class ReaderUnitsDaoTest {

	private static ReaderUnitsDao readerUnitsDao;
	private String filePath = "D:\\Workspaces\\eclipse-jee-3.5\\library\\src\\main\\webapp\\doc\\ExcelData\\readerUnits.xls";
//	private String filePath = "E:\\works\\myproject\\webproject\\src\\main\\webapp\\doc\\readerUnits.xls";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		readerUnitsDao = (ReaderUnitsDao) BaseSpringBeans.getInstance()
				.getBean("readerUnitsDao");
	}

	@Test
	public void initTest() {
		List<ReaderUnits> readerUnitses = new ArrayList<ReaderUnits>();
		// 取得excel文件
		File file = new File(filePath);
		Workbook wb;
		try {
			// 打开workbook
			wb = Workbook.getWorkbook(file);
			// 打卡第一个sheet
			Sheet sheet = wb.getSheet(0);
			// 取得行数
			int row = sheet.getRows();
			// 取得列数
			int col = sheet.getColumns();
			// 取到一行中每列的值赋值给一个Category对象对应的属性，直到最后一行
			for (int i = 0; i < row; i++) {
				ReaderUnits readerUnits = new ReaderUnits();
				ReaderUnits pReaderUnits = new ReaderUnits();
				for (int j = 0; j < col; j++) {
					Cell cell = sheet.getCell(j, i);
					if (cell.getType() == CellType.NUMBER) {
						NumberCell numberCell = (NumberCell) cell;
						switch (j) {
						case 0:
							String temp = String.valueOf(numberCell.getValue());
							readerUnits.setUnitcode(temp.substring(0, temp.length()-2));
							break;
						case 4:
							pReaderUnits.setUnitId(((long)numberCell.getValue()));
							readerUnits.setParentUnit(pReaderUnits);
							break;
						}
					} else if (cell.getType() == CellType.LABEL) {
						LabelCell lc = (LabelCell) cell;
						switch (j) {
						case 1:
							readerUnits.setUnitName(lc.getContents());
							break;
						case 2:
							readerUnits.setUnitShortName(lc.getContents());
							break;
						case 3:
							readerUnits.setUnitDesc(lc.getContents());
							break;
						}
					}
				}
				readerUnitses.add(readerUnits);
			}

			// 批量增加Category
			try {
				readerUnitsDao.insertReaderUnitsesBatch(readerUnitses);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
