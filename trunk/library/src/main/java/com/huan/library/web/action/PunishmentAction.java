package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.Charge;
import com.huan.library.domain.model.Punishment;
import com.huan.library.domain.service.DictItemService;
import com.huan.library.domain.service.PunishmentService;
import com.huan.library.web.view.DictItemView;
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
	
	private Charge project;  //项目
	private Punishment punishment; //罚款

	@Autowired
	private PunishmentService punishmentService;  //罚款service
	
	@Autowired
	private DictItemService dictItemService;   //数据字典service 

	/**
	 * 显示增加罚款
	 * @return
	 * @throws Exception
	 */
	
	public String showSavePunishment()  {
    	List<DictItemView> dictItemViews = new ArrayList<DictItemView>();
		try {
			dictItemViews = dictItemService.getDictItemByItemClass(Charge.class.getName());
		} catch (Exception e) {
		  e.printStackTrace();
		  return Action.ERROR;
		}
		return Action.SUCCESS;
    }
	
	/**
	 * 增加罚款
	 * @return
	 * @throws Exception
	 */
	
	public String savePunishment()  {
		Punishment punishmentCopy = new Punishment();
		try {
			punishmentCopy = punishmentService.addOrModifyPunlishment(punishment);
		} catch (Exception e) {
		  e.printStackTrace();
		  return Action.ERROR;
		}
		return Action.SUCCESS;
    }
	
	public void setPunishmentService(PunishmentService punishmentService) {
		this.punishmentService = punishmentService;
	}

	public void setDictItemService(DictItemService dictItemService) {
		this.dictItemService = dictItemService;
	}
	
	public Charge getProject() {
		return project;
	}

	public void setProject(Charge project) {
		this.project = project;
	}

	public Punishment getPunishment() {
		return punishment;
	}

	public void setPunishment(Punishment punishment) {
		this.punishment = punishment;
	}

	
}
