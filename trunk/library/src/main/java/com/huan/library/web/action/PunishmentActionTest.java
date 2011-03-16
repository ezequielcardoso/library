package com.huan.library.web.action;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.Project;
import com.huan.library.domain.model.Punishment;
import com.huan.library.domain.model.dict.DictItem;
import com.huan.library.domain.service.DictItemService;
import com.huan.library.web.view.DictItemView;
/**
 * 罚款action测试
 * @author huan
 * @time  2011-3-16 下午11:50:41
 */
public class PunishmentActionTest {

	private static PunishmentAction punishmentAction;
	private static DictItemService dictItemService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		punishmentAction = (PunishmentAction)BaseSpringBeans.getInstance().getBean("punishmentAction");
		dictItemService = (DictItemService)BaseSpringBeans.getInstance().getBean("dictItemService");
	}

	@Test
	public void testPunishmentInit(){
		List<DictItemView> dictItemViews = new ArrayList<DictItemView>();  
		Project project = new Project();
		try{
		Punishment punishment = new Punishment();
		punishment.setOperatorDate(new Date());
		punishment.setOperator(null);
		dictItemViews = dictItemService.getDictItemByItemClass(Project.class.getName());
		for(DictItemView dictItemView:dictItemViews){
			project = (Project)dictItemService.findDictItemById(1);
		}
		punishment.setProject(project);
		
		punishmentAction.savePunishment();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
