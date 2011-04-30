package com.huan.library.domain.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.borrowReturn.BorrowReturn;
import com.huan.library.domain.service.BorrowReturnService;
import com.huan.library.infrastructure.persistence.BorrowReturnDao;
import com.huan.library.util.DateFormatUtil;
import com.huan.library.util.ExcelOperate;
import com.huan.library.util.ExcelStyle;
import com.huan.library.web.view.BorrowReturnView;
/**
 * 书刊借阅归还service实现
 * @author huan
 * @time  2011-3-17 下午06:36:32
 */
@Service("borrowReturnService")
public class BorrowReturnServiceImpl implements BorrowReturnService {
  
	@Autowired
	private BorrowReturnDao borrowReturnDao;
	
	public BorrowReturn addOrModifyBorrow(BorrowReturn borrowReturn)  {
		return borrowReturnDao.saveOrUpdate(borrowReturn);
	}

	public BorrowReturn addReturn(BorrowReturn borrowReturn)  {
		return borrowReturnDao.saveOrUpdate(borrowReturn);
	}
	
	public BorrowReturn getBRByBarCode(String barCode)  {
		return borrowReturnDao.selectBRByBookBar(barCode);
	}
	
	public BorrowReturn getBRById(Long id) {
		return borrowReturnDao.selectBRById(id);
	}
	
	public List<BorrowReturn> getByBarCodeOrReaderCode(BorrowReturnView borrowReturnView) {
		return borrowReturnDao.selectBorrowReturn(borrowReturnView);
	}
	
	public void setBorrowReturnDao(BorrowReturnDao borrowReturnDao) {
		this.borrowReturnDao = borrowReturnDao;
	}

	public List<BorrowReturn> findBorrowReturns(
			BorrowReturnView borrowReturnView)  {
		return borrowReturnDao.selectBorrowReturns(borrowReturnView);
	}
	
	public List<BorrowReturn> aboutToDueBorrowReturns() {
		return borrowReturnDao.aboutToDueBorrowReturn();
	}

	public String exportExcel(String rootDir, BorrowReturnView borrowReturnView)
			 {
		List<BorrowReturn> borrowReturns = new ArrayList<BorrowReturn>();
		WritableWorkbook ww ;
		String fileName = "upload"+File.separator+"booksBorrored.xls";
		File file = new File(rootDir + fileName);
		try {
			 borrowReturns = borrowReturnDao.selectBorrowReturn(borrowReturnView);
			 ww = Workbook.createWorkbook(file);
			 WritableSheet ws;
			 if(borrowReturnView.getIsBook()== 1){
				 ws = ww.createSheet("图书借阅信息", 0);
	             ExcelOperate.addLabelToSheet(ws, 0, 0, 9, 0, "图书借阅信息", ExcelStyle.getHeaderStyle());   
				 ExcelOperate.addLabelToSheet(ws, 0, 1, "图书条形码", ExcelStyle.getTitleStyle());   
				 ExcelOperate.addLabelToSheet(ws, 1, 1, "读者条形码", ExcelStyle.getTitleStyle());   
				 ExcelOperate.addLabelToSheet(ws, 2, 1, "读者姓名", ExcelStyle.getTitleStyle());   
				 ExcelOperate.addLabelToSheet(ws, 3, 1, "书名", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 4, 1, "借阅日期", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 5, 1, "应还日期", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 6, 1, "实还日期", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 7, 1, "逾期天数", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 8, 1, "罚金", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 9, 1, "续借次数", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 10, 1, "图书状态", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 11, 1, "图书类别", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 12, 1, "读者单位", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 13, 1, "读者类别", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 14, 1, "存放位置", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 15, 1, "借阅操作员", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 16, 1, "归还操作员", ExcelStyle.getTitleStyle());
			 }else{
				 ws = ww.createSheet("期刊借阅信息", 0);
	             ExcelOperate.addLabelToSheet(ws, 0, 0, 9, 0, "期刊借阅信息", ExcelStyle.getHeaderStyle());   
				 ExcelOperate.addLabelToSheet(ws, 0, 1, "期刊条形码", ExcelStyle.getTitleStyle());   
				 ExcelOperate.addLabelToSheet(ws, 1, 1, "读者条形码", ExcelStyle.getTitleStyle());   
				 ExcelOperate.addLabelToSheet(ws, 2, 1, "读者姓名", ExcelStyle.getTitleStyle());   
				 ExcelOperate.addLabelToSheet(ws, 3, 1, "刊名", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 4, 1, "借阅日期", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 5, 1, "应还日期", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 6, 1, "实还日期", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 7, 1, "逾期天数", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 8, 1, "罚金", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 9, 1, "续借次数", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 10, 1, "期刊状态", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 11, 1, "期刊类别", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 12, 1, "读者单位", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 13, 1, "读者类别", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 14, 1, "存放位置", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 15, 1, "借阅操作员", ExcelStyle.getTitleStyle());
				 ExcelOperate.addLabelToSheet(ws, 16, 1, "归还操作员", ExcelStyle.getTitleStyle());
				 
				 
			 }
			 int count = 2;
			 for(BorrowReturn borrowReturn : borrowReturns){
	            	ExcelOperate.addLabelToSheet(ws, 0, count, borrowReturn.getBook().getBarCode(), ExcelStyle.getContentStyle());   
	            	ExcelOperate.addLabelToSheet(ws, 1, count, borrowReturn.getReader().getBarCode(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 2, count, borrowReturn.getReader().getReaderName(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 3, count, borrowReturn.getBook().getBookName(), ExcelStyle.getContentStyle());
	            	
	            	String borrowedDate = DateFormatUtil.format(borrowReturn.getBorrowedDate(), "yyyy-MM-dd");
					ExcelOperate.addLabelToSheet(ws, 4, count, DateFormatUtil.convertToDate(borrowedDate), ExcelStyle.getDateStyle());
//	            	ExcelOperate.addLabelToSheet(ws, 4, count, borrowReturn.getBorrowedDate(), ExcelStyle.getContentStyle());
	            	
	            	String duetoReturnDate = DateFormatUtil.format(borrowReturn.getDuetoReturnDate(), "yyyy-MM-dd");
					ExcelOperate.addLabelToSheet(ws, 5, count, DateFormatUtil.convertToDate(duetoReturnDate), ExcelStyle.getDateStyle());
//	            	ExcelOperate.addLabelToSheet(ws, 5, count, borrowReturn.getDuetoReturnDate(), ExcelStyle.getContentStyle());
	            	
	            	String realityReturndate = DateFormatUtil.format(borrowReturn.getRealityReturndate(), "yyyy-MM-dd");
					ExcelOperate.addLabelToSheet(ws, 6, count, DateFormatUtil.convertToDate(realityReturndate), ExcelStyle.getDateStyle());
//	            	ExcelOperate.addLabelToSheet(ws, 6, count, borrowReturn.getRealityReturndate(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 7, count, borrowReturn.getOverdueDays(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 8, count, borrowReturn.getPuniMoney(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 9, count, borrowReturn.getRenewTimes(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 10, count, borrowReturn.getBook().getBookState().getItemName(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 11, count, borrowReturn.getBook().getFirstCategory().getItemName(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 12, count, borrowReturn.getReader().getReaderUnits().getUnitName(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 13, count, borrowReturn.getReader().getReaderType().getReaderCateName(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 14, count, borrowReturn.getBook().getLocation(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 15, count, borrowReturn.getBorrowOperator(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 16, count, borrowReturn.getReturnOperator(), ExcelStyle.getContentStyle());
	            	
	            	count++;
	            }
			 
			 for (int i = 0; i < 18; i++) {   
	                ws.setColumnView(i, 16);   
	            }   
	            ws.setRowView(0, 20); 
	            ww.write();   
	            ww.close();   
	            System.out.println("写入excel成功！");
			 
		} catch (Exception e) {
		  e.printStackTrace();
		  System.out.println("写入excel失败！");
		}
		return fileName;
	}

}
