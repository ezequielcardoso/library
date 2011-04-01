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
import com.huan.library.domain.model.rights.Function;

/**
 * 功能
 * 
 * @author Administrator
 * @time 2011-3-18 下午06:19:20
 */
public class FunctionDaoTest {

//	private String filePath = "D:\\Workspaces\\eclipse-jee-3.5\\library\\src\\main\\webapp\\doc\\ExcelData\\functionsCopy.xls";
	private String filePath = "E:\\works\\myproject\\webproject\\src\\main\\webapp\\doc\\functionsCopy.xls";
	private static FunctionDao functionDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		functionDao = (FunctionDao) BaseSpringBeans.getInstance().getBean(
				"functionDao");
	}

	@Test
	public void testImportFunctionsFromExcel() {
		List<Function> functions = new ArrayList<Function>();
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
				Function function = new Function();
				Function pFunction = new Function();
				for (int j = 0; j < col; j++) {
					Cell cell = sheet.getCell(j, i);
					if (cell.getType() == CellType.NUMBER) {
						NumberCell numberCell = (NumberCell) cell;
						switch (j) {
						case 0:
							String temp = String.valueOf(numberCell.getValue());
							function.setFuncId(temp.substring(0, temp.length()-2));
							break;
						case 2:
							boolean funcActive = false;
							if (numberCell.getValue() == 1) {
								funcActive = false;
							}
							function.setFuncActive(funcActive);
							break;
						case 3:
							function.setFuncOrder((int) numberCell.getValue());
							break;
						case 6:
							function.setLevel((int) numberCell.getValue());
							break;
						case 7:
							Boolean isLeaf = false;
							if (numberCell.getValue() == 1) {
								isLeaf = true;
							}
							function.setLeaf(isLeaf);
							break;
						case 8:
							Boolean isChecked = false;
							if (numberCell.getValue() == 1) {
								isChecked = true;
							}
							function.setLeaf(isChecked);
							break;
						case 9:
							function.setResCmpId(String.valueOf(numberCell.getValue()));
							break;
						case 13:
							temp = String.valueOf(numberCell.getValue());
							pFunction.setFuncId(temp.substring(0, temp.length()-2));
							function.setParent(pFunction);
							break;
						}
					} else if (cell.getType() == CellType.LABEL) {
						LabelCell lc = (LabelCell) cell;
						switch (j) {
						case 1:
							function.setFuncName(lc.getContents());
							break;
						case 4:
							function.setFuncLogUrl(lc.getContents());
							break;
						case 5:
							function.setFuncLogDesc(lc.getContents());
							break;
						case 10:
							function.setResCmpText(lc.getContents());
							break;
						case 11:
							function.setResCmpIconCls(lc.getContents());
							break;
						case 12:
							function.setResCmpHandURL(lc.getContents());
							break;
						}
					}
				}
				functions.add(function);
			}
			// 批量增加Category
			try {
				functionDao.insertFunctionsBatch(functions);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
