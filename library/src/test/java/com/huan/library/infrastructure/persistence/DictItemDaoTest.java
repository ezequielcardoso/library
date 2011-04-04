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
import com.huan.library.domain.model.dict.DictItem;

/**
 * �����ֵ�dao����
 * 
 * @author huan
 * @time 2011-3-13 ����07:50:41
 */
public class DictItemDaoTest {

	private static DictItemDao dictItemDao;
	
	private String filePath = Constants.ExcelDir + "dictitem.xls";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dictItemDao = (DictItemDao) BaseSpringBeans.getInstance().getBean(
				"dictItemDao");
	}

	@Test
	public void testImportItemsFromExcel() {
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
			// ȡ��һ����ÿ�е�ֵ��ֵ��һ��DictItem�����Ӧ�����ԣ�ֱ�����һ��
			List<DictItem> items = new ArrayList<DictItem>();
			for (int i = 1; i < row; i++) {
				DictItem dictItem = new DictItem();
				DictItem pDictItem = new DictItem();
				for (int j = 0; j < col; j++) {
					Cell cell = sheet.getCell(j, i);
					if (cell.getType() == CellType.NUMBER) {
						NumberCell numberCell = (NumberCell) cell;
						switch (j) {
						case 3:
							boolean itemActive = false;
							if (numberCell.getValue() == 1) {
								itemActive = true;
							}
							dictItem.setItemActive(itemActive);
							break;
						case 7:
							dictItem.setLevel((int)numberCell.getValue());
							break;
						case 9: 
							dictItem.setItemOrder((int)numberCell.getValue());
							break;		
						}
					} else if (cell.getType() == CellType.LABEL) {
						LabelCell lc = (LabelCell) cell;
						switch (j) {
						case 0:
							dictItem.setItemId(lc.getContents());
							break;
						case 2:
							dictItem.setItemDesc(lc.getContents());
							break;
						case 6:
							dictItem.setItemName(lc.getContents());
							break;
						case 8: // parent
							pDictItem.setItemId(lc.getContents());
							dictItem.setParent(pDictItem);
							break;
						case 10:
							dictItem.setItemType(lc.getContents());
							break;
						}
					}
					dictItem.setLeaf(false);
					dictItem.setChecked(false);
					dictItem.setItemCode(null);
				}
				items.add(dictItem);
			}
			dictItemDao.insertDictItemsBatch(items);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testImportCategorysFromExcel() {
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
			// ȡ��һ����ÿ�е�ֵ��ֵ��һ��DictItem�����Ӧ�����ԣ�ֱ�����һ��
			List<DictItem> items = new ArrayList<DictItem>();
			for (int i = 1; i < row; i++) {
				DictItem dictItem = new DictItem();
				DictItem pDictItem = new DictItem();
				for (int j = 0; j < col; j++) {
					Cell cell = sheet.getCell(j, i);
					if (cell.getType() == CellType.NUMBER) {
						NumberCell numberCell = (NumberCell) cell;
						switch (j) {
						case 3:
							boolean itemActive = false;
							if (numberCell.getValue() == 1) {
								itemActive = true;
							}
							dictItem.setItemActive(itemActive);
							break;
						case 7:
							dictItem.setLevel((int)numberCell.getValue());
							break;
						case 9: 
							dictItem.setItemOrder((int)numberCell.getValue());
							break;		
						}
					} else if (cell.getType() == CellType.LABEL) {
						LabelCell lc = (LabelCell) cell;
						switch (j) {
						case 0:
							dictItem.setItemId(lc.getContents());
							break;
						case 2:
							dictItem.setItemDesc(lc.getContents());
							break;
						case 6:
							dictItem.setItemName(lc.getContents());
							break;
						case 8: // parent
							pDictItem.setItemId(lc.getContents());
							dictItem.setParent(pDictItem);
							break;
						case 10:
							dictItem.setItemType(lc.getContents());
							break;
						}
					}
					dictItem.setLeaf(false);
					dictItem.setChecked(false);
					dictItem.setItemCode(null);
				}
				items.add(dictItem);
			}
			dictItemDao.insertDictItemsBatch(items);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
