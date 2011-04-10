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

import com.huan.library.domain.model.reader.Reader;
import com.huan.library.infrastructure.persistence.ReaderDao;
import com.huan.library.web.view.ReaderView;

/**
 * 读者持久化实现
 * 
 * @author huan
 * @time 2011-3-14 下午01:04:36
 */
@Repository("readerDao")
public class ReaderDaoImpl extends BaseDaoImpl<Reader> implements ReaderDao {

	public List<Reader> selectUsers(final ReaderView readerView) throws Exception {
		List<Reader> readers = new ArrayList<Reader>();
		try {
			StringBuilder sql = new StringBuilder();
			StringBuilder sql_ = new StringBuilder();

			sql.append(" select new Reader( r.id, r.cardNo, r.password, r.barCode, r.readerName, r.birthday,"
							+ " r.sex, r.leftMoney, r.email, r.contactTel, r.entyDate, r.effectiveDate, r.readerPic, r.spell"
							+ ", r.readerDesc, r.certificateNo, t_ru.unitId, t_ru.unitcode, t_ru.unitName, t_c.itemId, t_c.itemCode,"
							+ " t_c.itemName, t_rt.id, t_rt.readerCateCode, t_rt.readerCateName, t_rs.itemId, t_rs.itemCode, t_rs.itemName )");
			sql_.append(" select count(r) ");

			sql.append(" from Reader r ");
			sql_.append(" from Reader r ");

			StringBuilder joinSub = new StringBuilder();
			joinSub.append(" left join r.readerUnits t_ru ");
			joinSub.append(" left join r.certificate t_c ");
			joinSub.append(" left join r.readerType t_rt ");
			joinSub.append(" left join r.cardState t_rs ");
			
			sql.append(joinSub);
			sql_.append(joinSub);
			
			sql.append(" where 1=1 ");
			sql_.append(" where 1=1 ");
			
			final String sqlIn = sql.toString();
			HibernateCallback callback = new HibernateCallback(){
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(sqlIn);
					//判断是不是分页
					if(readerView!=null&&readerView.getIsPage()){
						query.setFirstResult(readerView.getStart());
						query.setMaxResults(readerView.getLimit());
					}
					return query.list();
				}
			};
			readers = (List<Reader>)getHibernateTemplate().executeFind(callback);
			
			final String sqlIn_ = sql_.toString();
			HibernateCallback callback_ = new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(sqlIn_);
					return query.list();
				}
			};
			
			Long totalCount = (Long)getHibernateTemplate().executeFind(callback_).iterator().next();
			
			readerView.setTotalCount(totalCount);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return readers;
	}

	public void insertReaders(List<Reader> readers) throws Exception {
		try {
			SessionFactory sessionFactory = this.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			int i = 0;
			for (Reader reader : readers) {
				session.save(reader);
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
