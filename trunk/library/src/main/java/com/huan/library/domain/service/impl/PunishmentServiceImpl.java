package com.huan.library.domain.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.Punishment;
import com.huan.library.domain.service.PunishmentService;
import com.huan.library.infrastructure.persistence.PunishmentDao;
import com.huan.library.util.DateFormatUtil;
import com.huan.library.util.ExcelOperate;
import com.huan.library.util.ExcelStyle;
import com.huan.library.web.view.PunishmentView;

/**
 * 罚款service实现
 * 
 * @author huan
 * @time 2011-3-16 下午11:16:23
 */
@Service("punishmentService")
public class PunishmentServiceImpl implements PunishmentService {

	@Autowired
	public PunishmentDao punishmentDao;

	public void setPunishmentDao(PunishmentDao punishmentDao) {
		this.punishmentDao = punishmentDao;
	}

	public Punishment addOrModifyPunlishment(Punishment punishment) {
		return punishmentDao.saveOrUpdate(punishment);
	}

	public List<Punishment> findPunishments(PunishmentView punishmentView) {
		return punishmentDao.selectPunishments(punishmentView);
	}

	public String exportExcel(String rootDir, PunishmentView punishmentView) {
		List<Punishment> punishments = new ArrayList<Punishment>();
		WritableWorkbook ww;
		String fileName = "upload" + File.separator + "readerAccounts.xls";
		File file = new File(rootDir + fileName);
		try {
			punishments = punishmentDao.selectPunishments(punishmentView);
			ww = Workbook.createWorkbook(file);
			WritableSheet ws = ww.createSheet("读者账单信息", 0);
			ExcelOperate.addLabelToSheet(ws, 0, 0, 9, 0, "读者账单信息",
					ExcelStyle.getHeaderStyle());
			ExcelOperate.addLabelToSheet(ws, 0, 1, "读者条形码",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 1, 1, "读者姓名",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 2, 1, "读者单位",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 3, 1, "读者类别",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 4, 1, "罚金",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 5, 1, "收费项目",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 6, 1, "时间",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 7, 1, "操作员",
					ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 8, 1, "描述",
					ExcelStyle.getTitleStyle());

			int count = 2;
			for (Punishment punishment : punishments) {
				ExcelOperate
						.addLabelToSheet(ws, 0, count, punishment.getReader()
								.getBarCode(), ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 1, count, punishment
						.getReader().getReaderName(), ExcelStyle
						.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 2, count, punishment
						.getReader().getReaderUnits().getUnitName(),
						ExcelStyle.getContentStyle());
				
				ExcelOperate.addLabelToSheet(ws, 3, count,
						punishment.getReader().getReaderType().getReaderCateName(),
						ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 4, count,
						punishment.getPunishMoney(),
						ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 5, count, punishment
						.getCharge().getItemName(), ExcelStyle
						.getContentStyle());
				
				String operateDate = DateFormatUtil.format(punishment.getOperatorDate(), "yyyy-MM-dd");
				ExcelOperate.addLabelToSheet(ws, 6, count, DateFormatUtil.convertToDate(operateDate), ExcelStyle.getDateStyle());
//				ExcelOperate.addLabelToSheet(ws, 6, count,punishment.getOperatorDate(),ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 7, count,
						punishment.getOperator(), ExcelStyle.getContentStyle());
				ExcelOperate.addLabelToSheet(ws, 8, count,
						punishment.getEventsDesc(),
						ExcelStyle.getContentStyle());
				count++;
			}

			for (int i = 0; i < 9; i++) {
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
