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
	
	public List<DictItem> selectAllDictItems() throws Exception;

	public List<DictItem> getDictItemMapbyItemClass(String className);
	/**
	 * 批量导入
	 * @param dictItems
	 * @throws Exception
	 */
	public void insertDictItemsBatch(List<DictItem> dictItems) throws Exception;
	
	/**
	 * 批量导入
	 * @param dictItems
	 * @throws Exception
	 */
	public void insertCategorysBatch(List<Category> dictItems) throws Exception;

	/**
	 * 
	 * @param pid
	 * @param className
	 * @return
	 */
	public List<DictItem> getChildrenItem(String pid, String className) throws Exception ;
	
	public List<DictItem> getCategoryItem(String pid, 
			Integer level, String itemName) throws Exception ;
}
