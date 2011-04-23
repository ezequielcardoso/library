package com.huan.library.domain.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.reader.ReaderType;
import com.huan.library.domain.service.ReaderTypeService;
import com.huan.library.infrastructure.persistence.ReaderTypeDao;
import com.huan.library.util.ExcelOperate;
import com.huan.library.util.ExcelStyle;
import com.huan.library.web.view.ReaderTypeView;

/**
 * 读者类别service实现
 * @author huan
 * @time 2011-3-15 上午10:50:35
 */
@Service("readerTypeService")
public class ReaderTypeServiceImpl implements ReaderTypeService {

	@Autowired
	private ReaderTypeDao readerTypeDao;

	public void setReaderTypeDao(ReaderTypeDao readerTypeDao) {
		this.readerTypeDao = readerTypeDao;
	}

	public ReaderType addOrModifyReaderType(ReaderType readerType)
			throws Exception {
		ReaderType readertTypeCopy = new ReaderType();
		try {
			readertTypeCopy = readerTypeDao.saveOrUpdate(readerType);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return readertTypeCopy;
	}

	public void removeReaderType(ReaderType readerType) throws Exception {
		try {
			readerTypeDao.delete(readerType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ReaderType findReaderTypeById(int readerTypeId) throws Exception {
		ReaderType readerType = new ReaderType(); 
		try {
			readerType = readerTypeDao.selectById(readerTypeId);
		} catch (Exception e) {
		  e.printStackTrace();
		  return null;
		}
		return readerType;
	}

	public List<ReaderType> findAllReaderTypes() throws Exception {
		List<ReaderType> readerTypes = new ArrayList<ReaderType>();
		try {
			readerTypes = readerTypeDao.selectSmallTs();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return readerTypes;
	}

	public List<ReaderType> findReaderTypes(ReaderTypeView readerTypeView)
			throws Exception {
		List<ReaderType> readerTypes = new ArrayList<ReaderType>();
		try {
			readerTypes = readerTypeDao.selectReaderTypes(readerTypeView);
		} catch (Exception e) {
		    e.printStackTrace();
		    throw new Exception(e);
		}
		return readerTypes;
	}

	public String exportExcel(String rootDir, ReaderTypeView readerTypeView)
			throws Exception {
		List<ReaderType> readerTypes = new ArrayList<ReaderType>();
		WritableWorkbook ww ;
		String fileName = "upload" + File.separator + "readerTypes.xls";
		File file = new File(rootDir + fileName);
		try {
			readerTypes = readerTypeDao.selectReaderTypes(readerTypeView);
			ww = Workbook.createWorkbook(file);
			WritableSheet ws = ww.createSheet("读者类别", 0);
			 ExcelOperate.addLabelToSheet(ws, 0, 0, 9, 0, "读者类别", ExcelStyle.getHeaderStyle());   
			 ExcelOperate.addLabelToSheet(ws, 0, 1, "类别编码", ExcelStyle.getTitleStyle());   
			 ExcelOperate.addLabelToSheet(ws, 1, 1, "类别名称", ExcelStyle.getTitleStyle());   
			 ExcelOperate.addLabelToSheet(ws, 2, 1, "最大借阅天数", ExcelStyle.getTitleStyle());   
			 ExcelOperate.addLabelToSheet(ws, 3, 1, "最大借阅数量", ExcelStyle.getTitleStyle());
			 ExcelOperate.addLabelToSheet(ws, 4, 1, "租金", ExcelStyle.getTitleStyle());
			 
			 int count =2;
	           for(ReaderType readerType : readerTypes){
	            	ExcelOperate.addLabelToSheet(ws, 0, count, readerType.getReaderCateCode(), ExcelStyle.getContentStyle());   
	            	ExcelOperate.addLabelToSheet(ws, 1, count, readerType.getReaderCateName(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 2, count, readerType.getMaxBorrowDays(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 3, count, readerType.getMaxBorrowedQuantity(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 4, count, readerType.getRent(), ExcelStyle.getContentStyle());
	            	count++;
	            }
			 
	            for (int i = 0; i < 6; i++) {   
	                ws.setColumnView(i, 16);   
	            }   
	            ws.setRowView(0, 20); 
	            ww.write();   
	            ww.close();   
	            System.out.println("写入excel成功！");
		
		} catch (Exception e) {
		  e.printStackTrace();
		  System.out.println("写入excel失败！");
		  throw new Exception(e);
		}
		return fileName;
	}

}
