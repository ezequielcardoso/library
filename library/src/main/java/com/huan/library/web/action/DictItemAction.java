package com.huan.library.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.dict.DictItem;
import com.huan.library.domain.service.DictItemService;
import com.opensymphony.xwork2.Action;

/**
 * 字典action
 * @author huan
 * @time  2011-3-14 上午11:00:31
 */
@Controller("dictItemAction")
public class DictItemAction extends BaseActionSupport {
 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Autowired
	private DictItemService dictItemService;
    
    private DictItem dictItem;

	public DictItem getDictItem() {
		return dictItem;
	}

	public void setDictItem(DictItem dictItem) {
		this.dictItem = dictItem;
	}

	public void setDictItemService(DictItemService dictItemService) {
		this.dictItemService = dictItemService;
	}
    
	/**
	 * 添加字典
	 * @return
	 */
	public String saveDictItem()  {
		try {
			dictItemService.addOrModifyDictItem(dictItem);
		} catch (Exception e) {
		  e.printStackTrace();
		 return Action.ERROR;
		}
		 return Action.SUCCESS;
	}
	

	/**
	 * 修改字典
	 * @return
	 */
	public String modifyDictItem()  {
		try {
		 dictItemService.addOrModifyDictItem(dictItem);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 删除dictItem
	 * @return
	 */
	public String deleteDictItem() {
		try {
		  dictItemService.removeDictItem(dictItem);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 查找所有的dictItem
	 * @return
	 */
	public String findDictItem() {
		try {
		  List<DictItem> dictItemList = dictItemService.findAllDictItems();
		  request.setAttribute("dictItemList", dictItemList);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	
}
