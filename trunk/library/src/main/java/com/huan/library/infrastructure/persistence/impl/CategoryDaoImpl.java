package com.huan.library.infrastructure.persistence.impl;


import java.util.List;

import org.springframework.stereotype.Repository;


import com.huan.library.domain.model.book.Category;
import com.huan.library.infrastructure.persistence.CategoryDao;

@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

	
	@SuppressWarnings("unchecked")
	public List<Category> selectAllCategorys() throws Exception{
		return getHibernateTemplate().find("from Category");
	}
}
