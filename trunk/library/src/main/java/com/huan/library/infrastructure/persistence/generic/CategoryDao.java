package com.huan.library.infrastructure.persistence.generic;

import java.util.List;

import com.huan.library.domain.model.book.Category;


/**
 * 中图法Dao
 * @author huan
 * @time  2011-3-13 下午03:02:40
 */
public interface CategoryDao extends BaseDao<Category>{

	public List<Category> selectAllCategorys() throws Exception;

}
