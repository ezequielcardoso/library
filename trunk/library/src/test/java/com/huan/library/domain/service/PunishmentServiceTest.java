package com.huan.library.domain.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.Charge;
import com.huan.library.domain.model.Punishment;
import com.huan.library.domain.service.DictItemService;
import com.huan.library.domain.service.PunishmentService;
import com.huan.library.web.view.DictItemView;
/**
 * 罚款 service 测试
 * @author huan
 * @time  2011-3-16 上午 11:50:41
 */
public class PunishmentServiceTest {

	private static PunishmentService punishmentService; 
	private static DictItemService dictItemService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		punishmentService = (PunishmentService)BaseSpringBeans.getInstance().getBean("punishmentService");
		dictItemService = (DictItemService)BaseSpringBeans.getInstance().getBean("dictItemService");
	}

	@Test
	public void testPunishmentInit(){
		List<DictItemView> dictItemViews = new ArrayList<DictItemView>();  
		Charge project = new Charge();
		try{
		Punishment punishment = new Punishment();
		punishment.setEventsDesc("图书丢失");
		punishment.setPunishMoney(15.6f);
		punishment.setOperatorDate(new Date());
		
		//设置操作人
		punishment.setOperator(null);
		
		//操作项目
		dictItemViews = dictItemService.getDictItemByItemClass(Charge.class.getName());
		DictItemView dictItemView = dictItemViews.get(0);
		project.setItemId(dictItemView.getKey());
		project.setItemName(dictItemView.getComment());
		dictItemService.addOrModifyDictItem(project);
		punishment.setProject(project);
		
		punishmentService.addOrModifyPunlishment(punishment);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
