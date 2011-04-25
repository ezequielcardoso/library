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

	public List<Reader> selectReaders(final ReaderView readerView) {
		List<Reader> readers = new ArrayList<Reader>();

		StringBuilder sql = new StringBuilder();
		StringBuilder sql_ = new StringBuilder();

		sql.append(" select new Reader( r.id, r.cardNo, r.password, r.barCode, r.readerName, r.birthday,"
				+ " r.sex, r.leftMoney, r.email, r.contactTel, r.entyDate, r.effectiveDate, r.borrowedQuantiy, r.totalBQuantity, r.readerPic, r.spell"
				+ ", r.readerDesc, t_ru.unitId, t_ru.unitcode, t_ru.unitName, t_ru.unitShortName, t_c.itemId, t_c.itemCode,"
				+ " t_c.itemName, t_rt.id, t_rt.readerCateCode, t_rt.readerCateName, t_rt.maxBorrowDays, t_rt.maxBorrowedQuantity,"
				+ " t_rt.rent , t_rs.itemId, t_rs.itemCode, t_rs.itemName )");
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

		StringBuilder whereSub = new StringBuilder();
		if (readerView.getUnitId() != null
				&& !"".equals(readerView.getUnitId())) {
			whereSub.append(" and t_ru.unitId = (:unitId) ");
		}
		if (readerView.getReaderName() != null
				&& !"".equals(readerView.getReaderName())) {
			whereSub.append(" and r.readerName like (:readerName) ");
		}
		if (readerView.getCardNo() != null
				&& !"".equals(readerView.getCardNo())) {
			whereSub.append(" and r.cardNo = (:cardNo ) ");
		}
		if (readerView.getUnitName() != null
				&& !"".equals(readerView.getUnitName())) {
			whereSub.append(" and t_ru.unitName like (:unitName) ");
		}
		if (readerView.getReaderCateName() != null
				&& !"".equals(readerView.getReaderCateName())) {
			whereSub.append(" and t_rt.readerCateName like (:readerCateName) ");
		}
		sql.append(whereSub);
		sql_.append(whereSub);
		
		// order by 子句
		StringBuilder orderSub = new StringBuilder();
		orderSub.append(" order by r.totalBQuantity desc ");

		sql.append(orderSub);
		sql_.append(orderSub);

		final String sqlIn = sql.toString();
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(sqlIn);
				// 判断是不是分页
				if (readerView != null && readerView.getIsPage()
						&& readerView.getStart() != null
						&& readerView.getLimit() != null) {
					query.setFirstResult(readerView.getStart());
					query.setMaxResults(readerView.getLimit());
				}
				if (readerView.getUnitId() != null
						&& !"".equals(readerView.getUnitId())) {
					query.setParameter("unitId", readerView.getUnitId());
				}
				String temp = "";
				if (readerView.getReaderName() != null
						&& !"".equals(readerView.getReaderName())) {
					temp = "%" + readerView.getReaderName().replace(" ", "%")
							+ "%";
					query.setParameter("readerName", temp);
				}
				if (readerView.getCardNo() != null
						&& !"".equals(readerView.getCardNo())) {
					query.setParameter("cardNo", readerView.getCardNo());
				}
				if (readerView.getUnitName() != null
						&& !"".equals(readerView.getUnitName())) {
					temp = "%" + readerView.getUnitName().replace(" ", "%")
							+ "%";
					query.setParameter("unitName", temp);
				}
				if (readerView.getReaderCateName() != null
						&& !"".equals(readerView.getReaderCateName())) {
					temp = "%"
							+ readerView.getReaderCateName().replace(" ", "%")
							+ "%";
					query.setParameter("readerCateName", temp);
				}
				return query.list();
			}
		};
		readers = (List<Reader>) getHibernateTemplate().executeFind(callback);

		final String sqlIn_ = sql_.toString();
		HibernateCallback callback_ = new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(sqlIn_);
				if (readerView.getUnitId() != null
						&& !"".equals(readerView.getUnitId())) {
					query.setParameter("unitId", readerView.getUnitId());
				}
				String temp = "";
				if (readerView.getReaderName() != null
						&& !"".equals(readerView.getReaderName())) {
					temp = "%" + readerView.getReaderName().replace(" ", "%")
							+ "%";
					query.setParameter("readerName", temp);
				}
				if (readerView.getCardNo() != null
						&& !"".equals(readerView.getCardNo())) {
					query.setParameter("cardNo", readerView.getCardNo());
				}
				if (readerView.getUnitName() != null
						&& !"".equals(readerView.getUnitName())) {
					temp = "%" + readerView.getUnitName().replace(" ", "%")
							+ "%";
					query.setParameter("unitName", temp);
				}
				if (readerView.getReaderCateName() != null
						&& !"".equals(readerView.getReaderCateName())) {
					temp = "%"
							+ readerView.getReaderCateName().replace(" ", "%")
							+ "%";
					query.setParameter("readerCateName", temp);
				}
				return query.list();
			}
		};

		Long totalCount = (Long) getHibernateTemplate().executeFind(callback_)
				.iterator().next();

		readerView.setTotalCount(totalCount);

		return readers;
	}

	public void insertReaders(List<Reader> readers) {

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

	}

	public Reader selectById(Long readerId) {
		Reader reader = new Reader();

		StringBuilder sql = new StringBuilder();
		sql.append(" from Reader r ");
		sql.append(" left join fetch r.readerUnits t_ru ");
		sql.append(" left join fetch r.certificate t_c ");
		sql.append(" left join fetch r.readerType t_rt ");
		sql.append(" left join fetch r.cardState t_rs ");
		sql.append(" where r.id = ? ");
		reader = (Reader) getHibernateTemplate().find(sql.toString(), readerId)
				.listIterator().next();

		return reader;
	}

	/**
	 *
	 */
	public Reader selectByBarCode(String barCode) {
		Reader reader = new Reader();

		StringBuilder sql = new StringBuilder();
		sql.append(" from Reader r ");
		sql.append(" left join fetch r.readerUnits t_ru ");
		sql.append(" left join fetch r.certificate t_c ");
		sql.append(" left join fetch r.readerType t_rt ");
		sql.append(" left join fetch r.cardState t_rs ");
		sql.append(" where r.barCode = ? ");
		reader = (Reader) getHibernateTemplate().find(sql.toString(), barCode)
				.listIterator().next();

		return reader;
	}

}
