package com.huan.library.infrastructure.persistence;


import java.io.File;

import jxl.Cell;
import jxl.CellType;
import jxl.LabelCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.dict.DictItem;

public class DictItemDao2TestTest {

	private static DictItemDao dictItemDao;
	private String filePath = "E:\\works\\myproject\\webproject\\src\\main\\webapp\\doc\\dictitem.xls";
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dictItemDao = (DictItemDao)BaseSpringBeans.getInstance().getBean("dictItemDao");
	}
	
	@Test
	public void testAdd(){
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
				DictItem dictItem = new DictItem();
				DictItem pDictItem = new DictItem();
				for (int j = 0; j < col; j++) {
					Cell cell = sheet.getCell(j, i);
					if (cell.getType() == CellType.NUMBER) {
						NumberCell numberCell = (NumberCell) cell;
						switch (j) {
						case 0:
							String temp = String.valueOf(numberCell
									.getValue());
							dictItem.setItemId(temp.substring(0, temp.length()-2));
							break;
						case 3:
							boolean itemActive = false;
							if (numberCell.getValue() == 1) {
								itemActive = false;
							}
							dictItem.setItemActive(itemActive);
							break;
						case 5:
							boolean leaf = false;
							if (numberCell.getValue() == 1) {
								leaf = false;
							}
							dictItem.setLeaf(leaf);
							break;
						case 7:
							dictItem.setLevel((int)numberCell.getValue());
							break;
						case 8: // parent
							temp = String.valueOf(numberCell.getValue());
							if(null == temp && "".equals(temp)){
							 dictItem.setParent(null);
							}
							break;	
						case 9: 
							dictItem.setItemOrder((int)numberCell.getValue());
							break;		
						}
					} else if (cell.getType() == CellType.LABEL) {
						LabelCell lc = (LabelCell) cell;
						switch (j) {
						case 1:
							dictItem.setChecked(true);
							break;
						case 2:
							dictItem.setDescription(lc.getContents());
							break;
						case 4:
							dictItem.setItemCode(lc.getContents());
							break;
						case 6:
							dictItem.setShortName(lc.getContents());
							break;
						case 10:
							dictItem.setItemType(lc.getContents());
							break;
						}
					}
				}
				dictItemDao.saveOrUpdate(dictItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

}
