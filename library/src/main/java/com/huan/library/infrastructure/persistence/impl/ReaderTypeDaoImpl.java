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

import com.huan.library.domain.model.reader.ReaderType;
import com.huan.library.infrastructure.persistence.ReaderTypeDao;
import com.huan.library.web.view.ReaderTypeView;
/**
 * 读者类别dao实现
 * @author huan
 * @time 2011-3-15 上午10:45:57
 */
@Repository("readerTypeDao")
public class ReaderTypeDaoImpl extends BaseDaoImpl<ReaderType> implements ReaderTypeDao {

	public List<ReaderType> selectReaderTypes(final ReaderTypeView readerTypeView)
			throws Exception {
		List<ReaderType> readerTypes= new ArrayList<ReaderType>();
		try {
			//查找所有的类别
			StringBuilder hql = new StringBuilder();
			//查找共记录
			StringBuilder hql_ = new StringBuilder();
			
			hql.append(" from ReaderType where 1=1 ");
			hql_.append(" select count(rt) from ReaderType rt where 1=1 ");
			
			StringBuilder whereSub = new StringBuilder();
			/**
			 * 拼接条件，如果某个字段的值不为空，则就作为查询条件
			 */
//			if(field!=null){
//				whereSub.append(" and b.fieldName = : fieldValue ");
//			}
			//继续拼接
			hql.append(whereSub);
			hql_.append(whereSub);
			
			// group by 子句

			// order by 子句
			
			//查询总记录
			final String halIn = hql.toString();
			HibernateCallback callback = new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(halIn);
					if(readerTypeView!=null && readerTypeView.getIsPage()){
						query.setMaxResults(readerTypeView.getLimit());
						query.setFirstResult(readerTypeView.getStart());
					}
					return query.list();
				}
			};
			readerTypes = (List<ReaderType>)getHibernateTemplate().executeFind(callback);
			
			//查询总的记录数
//			final String hqlIn_=hql_.toString();
//			HibernateCallback callback_ = new HibernateCallback(){
//
//				public Object doInHibernate(Session session)
//						throws HibernateException, SQLException {
//					Query query = session.createQuery(hqlIn_);
//					return query.uniqueResult();
//				}
//			};
//			Long totalCount = (Long)getHibernateTemplate().executeFind(callback_);
			
			//查询总的记录数
			final String hqlIn_ = hql_.toString();
			HibernateCallback callback_ = new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(hqlIn_);
					return query.list();
				}
			};
			Long totalCount = (Long)getHibernateTemplate().executeFind(callback_).iterator().next();
			//将查询的总记录数放到readertypeview里
			readerTypeView.setTotalCount(totalCount);
		} catch (Exception e) {
		  e.printStackTrace();
		  throw new Exception(e);
		}
		return readerTypes;
	}

	public void insertReaderTypeBatch(List<ReaderType> readerTypes)
			throws Exception {
		try {
			SessionFactory sessionFactory = this.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			int i = 0;
			for(ReaderType readerType:readerTypes){
				session.save(readerType);
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
