package com.huan.library.domain.service.gengeric.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.book.Category;
import com.huan.library.domain.service.gengeric.CategoryService;
import com.huan.library.infrastructure.persistence.generic.CategoryDao;
/**
 * 中图法业务层实现
 * @author huan
 * @time  2011-3-13 下午03:21:15
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
    
	
	public void addOrModifyCategory(Category category) throws Exception {
		Category parentCategory=category.getParent();
			if(parentCategory != null){
			category.setParent(parentCategory);	
			categoryDao.saveOrUpdate(category);
		 }
	}

	public void removeCategory(Category category) throws Exception {
	    categoryDao.delete(category);
	}
	
	public Category findCategoryById(String categoryId) throws Exception {
		return categoryDao.get(categoryId);
	}
	
	public List<Category> findAllCategorys() throws Exception {
		return categoryDao.selectAllCategorys();
	}


}
