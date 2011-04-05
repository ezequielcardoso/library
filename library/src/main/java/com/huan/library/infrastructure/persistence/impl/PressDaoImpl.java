package com.huan.library.infrastructure.persistence.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.book.Press;
import com.huan.library.infrastructure.persistence.PressDao;
import com.huan.library.web.view.PressView;
/**
 * 出版社持久化实现
 * @author huan
 * @time  2011-3-12 下午05:19:09
 */
@Repository("pressDao")
public class PressDaoImpl extends BaseDaoImpl<Press> implements PressDao{

	public List<Press> selectPresses(final PressView pressView) throws Exception {
		List<Press> presses = new ArrayList<Press>();
		try {
		  String hql_ = "select count(p) from Press p";
		  //查询总记录数
		  Long totalCount = (Long)getHibernateTemplate().find(hql_).iterator().next();
		  pressView.setTotalCount(totalCount);
		  //取得数据
		presses = (List<Press>)getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("select Press");
				if(pressView != null && pressView.getIsPage() 
						&& pressView.getStart()!=null && pressView.getLimit()!=null){
					query.setFirstResult(pressView.getStart());
					query.setMaxResults(pressView.getLimit());
				}
				return query.list();
			}
		  });
		} catch (Exception e) {
		  e.printStackTrace();
		}
		return presses;
	}

	
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
