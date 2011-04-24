package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.SysLog;
import com.huan.library.domain.service.SysLogService;
import com.huan.library.util.DateFormatUtil;
import com.huan.library.web.view.SysLogView;
import com.huan.library.web.view.form.ExtJsonForm;
import com.huan.library.web.view.grid.ExtGridLoad;
import com.opensymphony.xwork2.Action;

@Controller("sysLogAction")
public class SysLogAction extends BaseActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SysLogService sysLogService;

	private ExtGridLoad extGridLoad = new ExtGridLoad();
	private SysLogView sysLogView = new SysLogView();
	private ExtJsonForm extJsonForm = new ExtJsonForm();
	private Integer start;
	private Integer limit;
	
	public String sysLogMain(){
		return Action.SUCCESS;
	}
	
	public String findSysLogs(){
		try {
			sysLogView.setStart(start);
			sysLogView.setLimit(limit);
			List<SysLog> sysLogs = sysLogService.findSysLogs(sysLogView);
			extGridLoad.setRoot(this.convertToViews(sysLogs));
			extGridLoad.setTotalProperty(sysLogView.getTotalCount());
		} catch (Exception e) {
		  e.printStackTrace();
		  return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 导出Excel
	 * @return
	 */
	public String exportExcel(){
   	    try {
   	    	String rootDir = this.getWebRoot();
   	    	String fileName = sysLogService.exportExcel(rootDir,sysLogView);
   	    	extJsonForm.setData(fileName);
   	    	extJsonForm.setSuccess(true);
   	    	extJsonForm.setMsg("导出成功");
		} catch (Exception e) {
			extJsonForm.setData("");
   	    	extJsonForm.setSuccess(false);
   	    	extJsonForm.setMsg("导出失败");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	private List<SysLogView> convertToViews(List<SysLog> sysLogs){
		List<SysLogView> sysLogViews = new ArrayList<SysLogView>();
		for(SysLog sysLog:sysLogs){
			SysLogView sysLogView = new SysLogView();
			sysLogView.setId(sysLog.getId());
			if(sysLog.getOperateType()!=null &&!"".equals(sysLog.getOperateType())){
				sysLogView.setOperateType(sysLog.getOperateType());
			}
			if(sysLog.getFuncName()!=null &&!"".equals(sysLog.getFuncName())){
				sysLogView.setFuncName(sysLog.getFuncName());
			}
			if(sysLog.getOperateDescription()!=null &&!"".equals(sysLog.getOperateDescription())){
				sysLogView.setOperateDescription(sysLog.getOperateDescription());
			}
			if(sysLog.getOperator()!=null &&!"".equals(sysLog.getOperator())){
				sysLogView.setOperator(sysLog.getOperator());
			}
			if(sysLog.getOperateDate()!=null){
				sysLogView.setOperateDate(sysLog.getOperateDate());
			}
			if(sysLog.getOperateIPAddress()!=null &&!"".equals(sysLog.getOperateIPAddress())){
				sysLogView.setOperateIPAddress(sysLog.getOperateIPAddress());
			}
			sysLogViews.add(sysLogView);
		}
		return sysLogViews;
	}
	
	public void setSysLogService(SysLogService sysLogService) {
		this.sysLogService = sysLogService;
	}

	public ExtGridLoad getExtGridLoad() {
		return extGridLoad;
	}

	public void setExtGridLoad(ExtGridLoad extGridLoad) {
		this.extGridLoad = extGridLoad;
	}

	public SysLogView getSysLogView() {
		return sysLogView;
	}

	public void setSysLogView(SysLogView sysLogView) {
		this.sysLogView = sysLogView;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public ExtJsonForm getExtJsonForm() {
		return extJsonForm;
	}

	public void setExtJsonForm(ExtJsonForm extJsonForm) {
		this.extJsonForm = extJsonForm;
	}
	
	

}
