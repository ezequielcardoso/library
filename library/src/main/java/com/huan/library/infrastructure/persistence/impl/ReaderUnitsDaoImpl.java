package com.huan.library.infrastructure.persistence.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.reader.ReaderUnits;
import com.huan.library.infrastructure.persistence.ReaderUnitsDao;
/**
 * 读者单位dao实现
 * @author huan
 * @time  2011-3-17 上午10:52:07
 */
@Repository("readerUnitsDao")
public class ReaderUnitsDaoImpl extends BaseDaoImpl<ReaderUnits> implements
		ReaderUnitsDao {

	public void insertReaderUnitsesBatch(List<ReaderUnits> readerUnitses) throws Exception {
		try {

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
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
}
