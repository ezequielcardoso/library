package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.Punishment;
import com.huan.library.domain.service.PunishmentService;
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
	
	private ExtGridLoad extGridLoad = new ExtGridLoad();
	//返回增加后的业务逻辑
	private ExtJsonForm extJsonForm = new ExtJsonForm();
 
	private Punishment punishment = new Punishment();
	private List<Punishment> punishments = new ArrayList<Punishment>();
	private PunishmentView punishmentView = new PunishmentView();
    	
	private Integer start;
	private Integer limit;
	
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
				punishmentView.setReaderName(punishment.getReader().getReaderType().getReaderCateName());
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
	
	
	
}
