package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.domain.model.dict.DictItem;
import com.huan.library.web.view.DictItemView;

/**
 * 字典业务层
 * @author huan
 * @time  2011-3-14 上午10:40:59
 */
public interface DictItemService {
	/**
	 * 添加或是修改DictItem
	 * @param dictItem
	 * @throws Exception
	 */
	public DictItem addOrModifyDictItem(DictItem dictItem) throws Exception;
	
	/**
	 * 删除dictItem
	 * @param dictItem
	 * @throws Exception
	 */
	public void removeDictItem(DictItem dictItem) throws Exception;
	
	/**
	 * 根据id查找dictItem
	 * @param dictItemId
	 * @return
	 * @throws Exception
	 */
	public DictItem findDictItemById(int dictItemId) throws Exception;
	
	/**
	 * 查找所有的dictItem
	 * @return
	 * @throws Exception
	 */
	public List<DictItem> findAllDictItems() throws Exception;

	/**
	 * 根据类名的简单缩写查找DictItemView
	 * @param className
	 * @return
	 */
	public List<DictItemView> getDictItemByItemClass(String className);
	
}
