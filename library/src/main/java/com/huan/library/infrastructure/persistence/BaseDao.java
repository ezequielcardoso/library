package com.huan.library.infrastructure.persistence;

import java.io.Serializable;
import java.util.List;

import com.huan.library.util.PageModel;

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
	public T saveOrUpdate(T t) ;
	
    /**
	 * 删除实体
	 * @param t
	 * @return
	 */
    public void delete(T t) ;
	
	/**
	 * 根据Id查找实体
	 * @param entityId
	 * @return
	 */
	public T selectById(Serializable entityId) ;
	
	/**
	 * 返回小批量数据所有的实体
	 * @return
	 * @
	 */
	public List<T> selectSmallTs() ;
    
	/**
	 * 返回大批量数据
	 * @return
	 * @
	 */
	public List<T> selectMaxTs() ;
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSzie
	 * @return
	 * @
	 */
	public PageModel<T> selectByPage(int pageNo,int pageSize) ;
	
	/**
	 * 返回总的记录数
	 * @return
	 * @
	 */
	public Long selectTotalRecords() ;	
}
