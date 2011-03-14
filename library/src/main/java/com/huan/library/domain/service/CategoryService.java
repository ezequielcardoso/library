package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.domain.model.book.Category;

/**
 * 中图法service
 * @author huan
 * @time  2011-3-13 下午03:14:35
 */
public interface CategoryService {
	/**
	 * 添加或是修改
	 * @param category
	 * @throws Exception
	 */
	public void addOrModifyCategory(Category category) throws Exception;
	
	/**
	 * 删除
	 * @param category
	 * @throws Exception
	 */
	public void removeCategory(Category category) throws Exception;
	/**
	 * 根据ID查找分类
	 * @param categoryId
	 * @return
	 * @throws Exception
	 */
	public Category findCategoryById(String categoryId) throws Exception;
	/**
	 * 查找所有的分类
	 * @return
	 * @throws Exception
	 */
	public List<Category> findAllCategorys() throws Exception;

  
}
