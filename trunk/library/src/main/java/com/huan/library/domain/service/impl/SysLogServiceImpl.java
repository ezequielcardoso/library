package com.huan.library.domain.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.SysLog;
import com.huan.library.domain.model.book.Press;
import com.huan.library.domain.service.SysLogService;
import com.huan.library.infrastructure.persistence.SysLogDao;
import com.huan.library.util.DateFormatUtil;
import com.huan.library.util.ExcelOperate;
import com.huan.library.util.ExcelStyle;
import com.huan.library.web.view.SysLogView;

@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
   
	@Autowired
	private SysLogDao sysLogDao;
	
	public List<SysLog> findSysLogs(SysLogView sysLogView)  {
		return sysLogDao.selectSysLogs(sysLogView);
	}

	public void setSysLogDao(SysLogDao sysLogDao) {
		this.sysLogDao = sysLogDao;
	}

	public void save(SysLog sysLog) {
		this.sysLogDao.saveOrUpdate(sysLog);
	}

	public String exportExcel(String rootDir, SysLogView sysLogView) {
		List<SysLog> sysLogs = new ArrayList<SysLog>();
		WritableWorkbook ww;
		String fileName = "upload" + File.separator + "sysLogs.xls";
		File file = new File(rootDir + fileName);
		try {
			sysLogs = sysLogDao.selectSysLogs(sysLogView);
			ww = Workbook.createWorkbook(file);
			WritableSheet ws = ww.createSheet("日志信息", 0);
			ExcelOperate.addLabelToSheet(ws, 0, 0, 9, 0, "日志信息",
					ExcelStyle.getHeaderStyle());
			ExcelOperate.addLabelToSheet(ws, 0, 1, "操作类型",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 1, 1, "事件",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 2, 1, "操作人",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 3, 1, "日期",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 4, 1, "ip地址",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 5, 1, "业务描述",
					ExcelStyle.getTitleStyle());

			int count = 2;
			for (SysLog sysLog : sysLogs) {
				ExcelOperate.addLabelToSheet(ws, 0, count,
						sysLog.getOperateType(), ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 1, count,
						sysLog.getFuncName(), ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 2, count,
						sysLog.getOperator(), ExcelStyle.getContentStyle());
				String operateDate = DateFormatUtil.format(sysLog.getOperateDate(), "yyyy-MM-dd");
				ExcelOperate.addLabelToSheet(ws, 3, count, DateFormatUtil.convertToDate(operateDate), ExcelStyle.getDateStyle());
				ExcelOperate.addLabelToSheet(ws, 4, count, sysLog.getOperateIPAddress(),
						ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 5, count, sysLog.getOperateDescription(),
						ExcelStyle.getContentStyle());
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
			System.out.println("写入excel失败！");
			e.printStackTrace();
		}
		return fileName;
	}
   
}
