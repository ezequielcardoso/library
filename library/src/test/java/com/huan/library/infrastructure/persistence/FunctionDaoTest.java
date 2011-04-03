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
import com.huan.library.application.Constants;
import com.huan.library.domain.model.rights.Function;

/**
 * ����
 * 
 * @author Administrator
 * @time 2011-3-18 ����06:19:20
 */
public class FunctionDaoTest {

	private String filePath = Constants.ExcelDir + "functions.xls";
	private static FunctionDao functionDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		functionDao = (FunctionDao) BaseSpringBeans.getInstance().getBean(
				"functionDao");
	}

	@Test
	public void testImportFunctionsFromExcel() {
		List<Function> functions = new ArrayList<Function>();
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
			for (int i = 1; i < row; i++) {
				Function function = new Function();
				Function pFunction = new Function();
				for (int j = 0; j < col; j++) {
					Cell cell = sheet.getCell(j, i);
					if (cell.getType() == CellType.NUMBER) {
						NumberCell numberCell = (NumberCell) cell;
						switch (j) {
						case 3:
							function.setFuncOrder((int) numberCell.getValue());
							break;
						case 6:
							function.setLevel((int) numberCell.getValue());
							break;
						}
					} else if (cell.getType() == CellType.LABEL) {
						LabelCell lc = (LabelCell) cell;
						switch (j) {
						case 0:
							System.out.println(lc.getContents());
							function.setFuncId(lc.getContents());
							break;
						case 1:
							function.setFuncName(lc.getContents());
							break;
						case 4:
							function.setFuncLogUrl(lc.getContents());
							break;
						case 5:
							function.setFuncLogDesc(lc.getContents());
							break;
						case 9:
							function.setResCmpId(lc.getContents());
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
						case 13:
							pFunction.setFuncId(lc.getContents());
							function.setParent(pFunction);
							break;	
						}
					}
				}
				function.setFuncActive(true);
				function.setLeaf(false);
				function.setChecked(false);
				functions.add(function);
			}
			// ��������Category
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
