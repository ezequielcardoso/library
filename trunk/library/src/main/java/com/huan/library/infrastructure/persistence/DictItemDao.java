package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.domain.model.book.Category;
import com.huan.library.domain.model.dict.DictItem;

/**
 * 字典持久化层
 * @author huan
 * @time  2011-3-13 下午07:46:01
 */
public interface DictItemDao extends BaseDao<DictItem>{
	
	public List<DictItem> getByItemClass(String className);
	/**
	 * 批量导入
	 * @param dictItems
	 * @
	 */
	public void insertDictItemsBatch(List<DictItem> dictItems) ;
	
	/**
	 * 批量导入
	 * @param dictItems
	 * @
	 */
	public void insertCategorysBatch(List<Category> dictItems) ;

	/**
	 * 
	 * @param pid
	 * @param className
	 * @return
	 */
	public List<DictItem> getChildrenByPid(String pid, String className)  ;
	
	public List<Category> getCategoryChildrenByPid(String pid, 
			Integer level, String itemName)  ;
}
