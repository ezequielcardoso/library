package com.huan.library.infrastructure.persistence.generic;

import com.huan.library.domain.model.dict.DictItem;

/**
 * 字典持久化层
 * @author huan
 * @time  2011-3-13 下午07:46:01
 */
public interface DictItemDao {
	
	/**
	 * 添加或是修改数据字典
	 * @param dictItem
	 * @throws Exception
	 */
	public void saveOrUpdate(DictItem dictItem) throws Exception;
	
}
