package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.domain.model.book.Category;
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
	 * @
	 */
	public DictItem save(DictItem dictItem) ;
	
	/**
	 * 删除dictItem
	 * @param dictItem
	 * @
	 */
	public void remove(DictItem dictItem) ;
	
	/**
	 * 根据id查找dictItem
	 * @param dictItemId
	 * @return
	 * @
	 */
	public DictItem getById(int dictItemId) ;
	
	/**
	 * 根据类名的简单缩写查找DictItemView
	 * @param className
	 * @return
	 */
	public List<DictItemView> getByItemClass(String className)  ;

	/**
	 * 根据父节点的id和字典类型取得所有的子条目
	 * @param pid
	 * @param className
	 * @return
	 */
	public List<DictItem> getChildrenByPid(String pid, String className)  ;
	
	/**
	 * 根据Category父节点的id和字典类型取得所有的子条目
	 * @param pid
	 * @param className
	 * @return
	 */
	public List<Category> getCategoryChildrenByPid(String pid, Integer level, String itemName)  ;
	
}
