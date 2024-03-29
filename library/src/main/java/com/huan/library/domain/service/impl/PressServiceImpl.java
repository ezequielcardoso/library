package com.huan.library.domain.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.book.Press;
import com.huan.library.domain.service.PressService;
import com.huan.library.infrastructure.persistence.PressDao;
import com.huan.library.util.ExcelOperate;
import com.huan.library.util.ExcelStyle;
import com.huan.library.util.FileOperate;
import com.huan.library.util.PageModel;
import com.huan.library.web.view.PressView;

@Service("pressService")
public class PressServiceImpl implements PressService {

	@Autowired
	private PressDao pressDao;

	public PressDao getPressDao() {
		return pressDao;
	}

	public void setPressDao(PressDao pressDao) {
		this.pressDao = pressDao;
	}

	public Press addOrModifyPress(Press press) {
		return pressDao.saveOrUpdate(press);
	}

	public void removePress(Press press) {

		pressDao.delete(press);

	}

	public Press findPressById(Long pressId) {
		return pressDao.selectById(pressId);
	}

	public PageModel<Press> findPressesByPage(int pageNo, int pageSize) {
		return pressDao.selectByPage(pageNo, pageSize);
	}

	public List<Press> findPresses(PressView pressView) {
		return this.pressDao.selectPresses(pressView);
	}

	public String exportExcel(String rootDir, PressView pressView) {
		List<Press> presses = new ArrayList<Press>();
		WritableWorkbook ww;
		String fileName = "upload" + File.separator + "presses.xls";
		File file = new File(rootDir + fileName);
		try {
			presses = pressDao.selectPresses(pressView);
			ww = Workbook.createWorkbook(file);
			WritableSheet ws = ww.createSheet("出版社信息", 0);
			ExcelOperate.addLabelToSheet(ws, 0, 0, 9, 0, "出版社信息",
					ExcelStyle.getHeaderStyle());
			ExcelOperate.addLabelToSheet(ws, 0, 1, "代码",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 1, 1, "名称",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 2, 1, "出版第",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 3, 1, "邮编",
					ExcelStyle.getTitleStyle());

			int count = 2;
			for (Press press : presses) {
				ExcelOperate.addLabelToSheet(ws, 0, count,
						press.getPressISBN(), ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 1, count,
						press.getPressName(), ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 2, count,
						press.getPressAddress(), ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 3, count, press.getZipCode(),
						ExcelStyle.getContentStyle());
				count++;
			}

			for (int i = 0; i < 5; i++) {
				ws.setColumnView(i, 16);
			}
			ws.setRowView(0, 20);
			ww.write();
			ww.close();
			System.out.println("写入excel成功！");
		} catch (Exception e) {
			System.out.println("写入excel失败！");
			e.printStackTrace();
		}
		return fileName;
	}
}
