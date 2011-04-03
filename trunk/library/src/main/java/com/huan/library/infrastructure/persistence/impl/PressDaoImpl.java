package com.huan.library.infrastructure.persistence.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.book.Press;
import com.huan.library.infrastructure.persistence.PressDao;
/**
 * 出版社持久化实现
 * @author huan
 * @time  2011-3-12 下午05:19:09
 */
@Repository("pressDao")
public class PressDaoImpl extends BaseDaoImpl<Press> implements PressDao{

	public void insertPressBatch(List<Press> list)  throws Exception {
		try {
			SessionFactory sessionFactory = this.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			int i = 0;
			for (Press press : list) {
				session.save(press);
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

   
}
