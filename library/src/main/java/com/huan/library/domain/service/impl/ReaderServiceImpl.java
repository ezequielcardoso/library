package com.huan.library.domain.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.reader.Reader;
import com.huan.library.domain.service.ReaderService;
import com.huan.library.infrastructure.persistence.ReaderDao;
import com.huan.library.util.ExcelOperate;
import com.huan.library.util.ExcelStyle;
import com.huan.library.web.view.ReaderView;

/**
 * 读者业务层实现
 * 
 * @author huan
 * @time 2011-3-14 下午02:05:49
 */
@Service("readerService")
public class ReaderServiceImpl implements ReaderService {

	@Autowired
	private ReaderDao readerDao;

	public List<Reader> findReaders(ReaderView readerView) {
		return readerDao.selectReaders(readerView);
	}

	public Reader addOrModifyReader(Reader reader) {
		return readerDao.saveOrUpdate(reader);
	}

	public Reader findReaderByBarCode(String barCode) {
		return readerDao.selectByBarCode(barCode);
	}

	public Reader findReaderById(Long readerId) {
		return readerDao.selectById(readerId);
	}

	public void removeReader(Reader reader) {
		readerDao.delete(reader);
	}

	public String exportExcel(String rootDir, ReaderView readerView) {
		List<Reader> readers = new ArrayList<Reader>();
		WritableWorkbook ww;
		String fileName = "upload" + File.separator + "readers.xls";
		File file = new File(rootDir + fileName);
		try {
			readers = readerDao.selectReaders(readerView);
			ww = Workbook.createWorkbook(file);
			WritableSheet ws = ww.createSheet("读者信息", 0);
			ExcelOperate.addLabelToSheet(ws, 0, 0, 9, 0, "读者信息",
					ExcelStyle.getHeaderStyle());
			ExcelOperate.addLabelToSheet(ws, 0, 1, "借阅证号",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 1, 1, "密码",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 2, 1, "条形码",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 3, 1, "读者姓名",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 4, 1, "出生日期",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 5, 1, "姓别",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 6, 1, "邮箱",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 7, 1, "联系电话",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 8, 1, "余额",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 9, 1, "拼音",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 10, 1, "办证日期",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 11, 1, "有效日期",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 12, 1, "当前借阅数量",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 13, 1, "累计借阅数量",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 14, 1, "读者描述",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 15, 1, "读者单位",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 16, 1, "读者类别",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 17, 1, "证件类别",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 18, 1, "证件号码",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 19, 1, "借阅证状态",
					ExcelStyle.getTitleStyle());

			int count = 2;
			for (Reader reader : readers) {
				ExcelOperate.addLabelToSheet(ws, 0, count, reader.getCardNo(),
						ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 1, count,
						reader.getPassword(), ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 2, count, reader.getBarCode(),
						ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 3, count,
						reader.getReaderName(), ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 4, count,
						reader.getBirthday(), ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 5, count, reader.getSex(),
						ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 6, count, reader.getEmail(),
						ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 7, count,
						reader.getContactTel(), ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 8, count,
						reader.getLeftMoney(), ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 9, count, reader.getSpell(),
						ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 10, count,
						reader.getEntyDate(), ExcelStyle.getContentStyle());
				ExcelOperate
						.addLabelToSheet(ws, 11, count,
								reader.getEffectiveDate(),
								ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 12, count,
						reader.getBorrowedQuantiy(),
						ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 13, count,
						reader.getTotalBQuantity(),
						ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 14, count,
						reader.getReaderDesc(), ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 15, count, reader
						.getReaderUnits().getUnitName(), ExcelStyle
						.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 16, count, reader
						.getReaderType().getReaderCateName(), ExcelStyle
						.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 17, count, reader
						.getCertificate().getItemName(), ExcelStyle
						.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 18, count, reader
						.getCertificate().getItemCode(), ExcelStyle
						.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 19, count, reader
						.getCardState().getItemName(), ExcelStyle
						.getContentStyle());
				count++;
			}

			for (int i = 0; i < 20; i++) {
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

	public void setReaderDao(ReaderDao readerDao) {
		this.readerDao = readerDao;
	}
}
