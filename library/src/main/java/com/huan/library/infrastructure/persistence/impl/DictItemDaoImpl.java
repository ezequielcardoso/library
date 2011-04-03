package com.huan.library.infrastructure.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.dict.DictItem;
import com.huan.library.infrastructure.persistence.DictItemDao;

/**
 * 数据字典dao实现
 * 
 * @author huan
 * @time 2011-3-13 下午07:49:11
 */
@Repository("dictItemDao")
public class DictItemDaoImpl extends BaseDaoImpl<DictItem> implements
		DictItemDao {

	public List<DictItem> selectAllDictItems() throws Exception {
		List<DictItem> DictItemList = null;
		try {
			DictItemList = getHibernateTemplate().find("from DictItem");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return DictItemList;
	}

	public List<DictItem> getDictItemMapbyItemClass(String className) {
		String hql = " from " + className;
		return this.getHibernateTemplate().find(hql);
	}

	public void insertDictItemsBatch(List<DictItem> dictItems) throws Exception {
		try {
			SessionFactory sessionFactory = this.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			int i = 0;
			for (DictItem dictItem : dictItems) {
				session.save(dictItem);
				if (i % 100 == 0) {
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
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public List<DictItem> getChildrenItem(String pid, String className)  throws Exception {
		StringBuilder hql = new StringBuilder();
		hql.append(" from " + className + " as dict " ); 
		hql.append(" where dict.parent.itemId=? ");
		List<DictItem> items = new ArrayList<DictItem>();
		try {
			items = this.getHibernateTemplate().find(hql.toString(), pid);
		} catch (Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return items;
	}
}