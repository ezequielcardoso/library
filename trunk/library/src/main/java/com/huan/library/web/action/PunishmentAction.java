package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.Charge;
import com.huan.library.domain.model.LibInfo;
import com.huan.library.domain.model.Punishment;
import com.huan.library.domain.model.reader.Reader;
import com.huan.library.domain.service.LibInfoService;
import com.huan.library.domain.service.PunishmentService;
import com.huan.library.domain.service.ReaderService;
import com.huan.library.web.view.PunishmentView;
import com.huan.library.web.view.form.ExtJsonForm;
import com.huan.library.web.view.grid.ExtGridLoad;
import com.opensymphony.xwork2.Action;


/**
 * 罚款 action
 * @author huan
 * @time  2011-3-16 下午11:20:10
 */
@Controller("punishmentAction")
public class PunishmentAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PunishmentService punishmentService;
	@Autowired
	private ReaderService readerService;
	@Autowired
	private LibInfoService libInfoService;
	private ExtGridLoad extGridLoad = new ExtGridLoad();
	//返回增加后的业务逻辑
	private ExtJsonForm extJsonForm = new ExtJsonForm();
	private LibInfo libInfo = new LibInfo();
	
	private Punishment punishment = new Punishment();
	private List<Punishment> punishments = new ArrayList<Punishment>();
	private PunishmentView punishmentView = new PunishmentView();
    	
	private Integer start;
	private Integer limit;
	
	/**
	 * 显示读者账单主页面
	 * @return
	 */
	public String readerAccountMain(){
		return Action.SUCCESS;
	}
	
	/**
	 * 显示所有的罚款记录
	 * @return
	 */
	public String findPunishments() {
		try {
			punishmentView.setStart(start);
			punishmentView.setLimit(limit);
			punishments = punishmentService.findPunishments(punishmentView);
			extGridLoad.setRoot(this.convertToView(punishments));
			extGridLoad.setTotalProperty(punishmentView.getTotalCount());
		} catch (Exception e) {
		  e.printStackTrace();
		  return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	public String save(){
		try {
			Reader reader = readerService.findReaderByBarCode(punishmentView.getReaderBarCode());
			//读者资金减去
			reader.setLeftMoney(reader.getLeftMoney() - punishmentView.getPunishMoney());
			punishment.setReader(reader);
			
			//图书馆资金加上
			libInfo = libInfoService.findById(1L);
			libInfo.setLibFunds(libInfo.getLibFunds() + punishmentView.getPunishMoney());
			//罚款项目
			Charge charge = new Charge();
			charge.setItemId(punishmentView.getChargeId());
            punishment.setCharge(charge);
            //设置操作员
//          User currUser = (User)this.session.get("currUser");
//            punishment.setOperator(currUser.getUserName());
            
            punishment.setOperatorDate(new Date());
            punishment.setEventsDesc(punishmentView.getEventsDesc());
            punishment.setPunishMoney(punishmentView.getPunishMoney());
            
            this.formatPunishment(punishment);
			punishment = punishmentService.addOrModifyPunlishment(punishment);
			extJsonForm.setSuccess(true);
			extJsonForm.setMsg("罚款成功");
			extJsonForm.setData(null);
		} catch (Exception e) {
		  e.printStackTrace();
			extJsonForm.setSuccess(false);
			extJsonForm.setMsg("罚款失败");
			extJsonForm.setData(null);
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
   	    	String fileName = punishmentService.exportExcel(rootDir,punishmentView);
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
	
	private void formatPunishment(Punishment punish) {
		punish.setCharge((punish.getCharge()!=null && punish.getCharge().getItemId()!=null 
			   &&!"".equals(punish.getId())?punish.getCharge():null));
	   if(punish.getReader()!=null && punish.getReader().getId()!=null && !"".equals(punish.getReader().getId())){
		   if(punish.getReader().getReaderUnits()!=null && !"".equals(punish.getReader().getReaderUnits().getUnitId())){
			   punish.getReader().setReaderUnits(punish.getReader().getReaderUnits());
		   }else{
			   punish.getReader().setReaderUnits(null);
		   }
		   if(punish.getReader().getReaderType()!=null && !"".equals(punish.getReader().getReaderType().getId())){
			   punish.getReader().setReaderType(punish.getReader().getReaderType());
		   }else{
			   punish.getReader().setReaderType(null);
		   }
		   punish.setReader(punish.getReader());
	   }else{
		   punish.setReader(null);
	   }
	}

	private List<PunishmentView> convertToView(List<Punishment> punishments){
		List<PunishmentView> punishmentViews = new ArrayList<PunishmentView>();
		for(Punishment punishment:punishments){
			PunishmentView punishmentView = new PunishmentView();
			punishmentView.setId(punishment.getId());
			if(punishment.getPunishMoney()!=null){
				punishmentView.setPunishMoney(punishment.getPunishMoney());
			}
			if(punishment.getEventsDesc()!=null && !"".equals(punishment.getEventsDesc())){
				punishmentView.setEventsDesc(punishment.getEventsDesc());
			}
			if(punishment.getOperatorDate()!=null){
				punishmentView.setOperatorDate(punishment.getOperatorDate());
			}
			if(punishment.getOperator()!=null && !"".equals(punishment.getOperator())){
				punishmentView.setOperator(punishment.getOperator());
			}
			if(punishment.getCharge()!=null){
				punishmentView.setChargeId(punishment.getCharge().getItemId());
				punishmentView.setChargeName(punishment.getCharge().getItemName());
			}
			if(punishment.getReader()!=null){
				punishmentView.setReaderId(punishment.getReader().getId());
				punishmentView.setReaderBarCode(punishment.getReader().getBarCode());
				punishmentView.setReaderName(punishment.getReader().getReaderName());
			}
			if(punishment.getReader()!=null && punishment.getReader().getReaderUnits()!=null){
				punishmentView.setUnitId(punishment.getReader().getReaderUnits().getUnitId());
				punishmentView.setUnitName(punishment.getReader().getReaderUnits().getUnitName());	
			}
			if(punishment.getReader()!=null && punishment.getReader().getReaderType()!=null){
				punishmentView.setReaderTypeId(punishment.getReader().getReaderType().getId());
				punishmentView.setReaderCateName(punishment.getReader().getReaderType().getReaderCateName());
			}
			punishmentViews.add(punishmentView);
		}
		return punishmentViews; 
	}
	
	public ExtGridLoad getExtGridLoad() {
		return extGridLoad;
	}
	public void setExtGridLoad(ExtGridLoad extGridLoad) {
		this.extGridLoad = extGridLoad;
	}
	public ExtJsonForm getExtJsonForm() {
		return extJsonForm;
	}
	public void setExtJsonForm(ExtJsonForm extJsonForm) {
		this.extJsonForm = extJsonForm;
	}
	public Punishment getPunishment() {
		return punishment;
	}
	public void setPunishment(Punishment punishment) {
		this.punishment = punishment;
	}
	public PunishmentView getPunishmentView() {
		return punishmentView;
	}
	public void setPunishmentView(PunishmentView punishmentView) {
		this.punishmentView = punishmentView;
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
	public void setPunishmentService(PunishmentService punishmentService) {
		this.punishmentService = punishmentService;
	}
	public void setReaderService(ReaderService readerService) {
		this.readerService = readerService;
	}
	public void setLibInfoService(LibInfoService libInfoService) {
		this.libInfoService = libInfoService;
	}
	
}
