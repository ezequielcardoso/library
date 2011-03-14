package com.huan.library.infrastructure.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * 基础实体Dao
 * @author huan
 * @time  2011-3-12 下午06:16:40
 */
public interface BaseDao<T> {
	
	/**
	 * 添加实体
	 * @param t
	 */
	public T saveOrUpdate(T t) throws Exception;
	
    /**
	 * 删除实体
	 * @param t
	 * @return
	 */
    public void delete(T t) throws Exception;
	
	/**
	 * 根据Id查找实体
	 * @param entityId
	 * @return
	 */
	public T get(Serializable entityId) throws Exception;
	
	/**
	 * 返回小批量数据所有的实体
	 * @return
	 * @throws Exception
	 */
	public List<T> selectSmallTs() throws Exception;
    
	/**
	 * 返回大批量数据
	 * @return
	 * @throws Exception
	 */
	public List<T> selectMaxTs() throws Exception;
}
