package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.domain.model.dict.DictItem;

/**
 * 字典持久化层
 * @author huan
 * @time  2011-3-13 下午07:46:01
 */
public interface DictItemDao extends BaseDao<DictItem>{
	
	public List<DictItem> selectAllDictItems() throws Exception;
}
