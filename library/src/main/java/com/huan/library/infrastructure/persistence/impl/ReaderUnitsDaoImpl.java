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

import com.huan.library.domain.model.reader.ReaderUnits;
import com.huan.library.infrastructure.persistence.ReaderUnitsDao;

/**
 * 读者单位dao实现
 * 
 * @author huan
 * @time 2011-3-17 上午10:52:07
 */
@Repository("readerUnitsDao")
public class ReaderUnitsDaoImpl extends BaseDaoImpl<ReaderUnits> implements
		ReaderUnitsDao {

	public List<ReaderUnits> selectChildrenByPid(final Long pUnitId) {
		List<ReaderUnits> readerUnits = new ArrayList<ReaderUnits>();

		StringBuilder sql = new StringBuilder();
		sql.append(" from ReaderUnits ru ");
		sql.append(" left join fetch ru.parentUnit t_parent ");
		sql.append(" where t_parent.unitId=(:parentUnitId) ");

		final String sqlIn = sql.toString();
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(sqlIn);
				query.setParameter("parentUnitId", pUnitId);
				return query.list();
			}
		};
		readerUnits = (List<ReaderUnits>) getHibernateTemplate().executeFind(
				callback);
		return readerUnits;
	}

	public ReaderUnits getById(Long unitId) {
		ReaderUnits readerUnits = new ReaderUnits();
		StringBuilder sql = new StringBuilder();
		sql.append(" from ReaderUnits as ru ");
		sql.append(" where ru.unitId=? ");
		String sql_ = sql.toString();

		readerUnits = (ReaderUnits) getHibernateTemplate().find(sql_, unitId)
				.listIterator().next();
		return readerUnits;
	}

	public void insertReaderUnitsesBatch(List<ReaderUnits> readerUnitses) {

		SessionFactory sessionFactory = this.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		int i = 0;
		for (ReaderUnits readerUnits : readerUnitses) {
			session.save(readerUnits);
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
	}
}
