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
		// ȡ��excel�ļ�
		File file = new File(filePath);
		Workbook wb;
		try {
			// ��workbook
			wb = Workbook.getWorkbook(file);
			// �򿨵�һ��sheet
			Sheet sheet = wb.getSheet(0);
			// ȡ������
			int row = sheet.getRows();
			// ȡ������
			int col = sheet.getColumns();
			// ȡ��һ����ÿ�е�ֵ��ֵ��һ��Category�����Ӧ�����ԣ�ֱ�����һ��
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

			// ��������Category
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
