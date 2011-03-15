package com.huan.library.infrastructure.persistence.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.book.Category;
import com.huan.library.infrastructure.persistence.CategoryDao;

@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

	
	@SuppressWarnings("unchecked")
	public List<Category> selectAllCategorys() throws Exception{
		return getHibernateTemplate().find("from Category");
	}

	public void insertCategorysBatch(List<Category> categorys) throws Exception {
		try{
			
			SessionFactory sessionFactory = this.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			int i = 0;
			for(Category category : categorys){
				session.save(category);
				if(i%100==0){
					tx.begin();
					session.flush();
					session.clear();
					tx.commit();
				}
				i++;
			}
			tx.begin();
			session.flush();
			session.clear();
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
	}
}
