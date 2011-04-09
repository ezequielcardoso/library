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
 * 
 * @author huan
 * @time 2011-3-12 下午05:19:09
 */
@Repository("pressDao")
public class PressDaoImpl extends BaseDaoImpl<Press> implements PressDao {

	public List<Press> selectPresses(final PressView pressView)
			throws Exception {
		List<Press> presses = new ArrayList<Press>();
		try {

			StringBuilder hql = new StringBuilder();
			StringBuilder hql_ = new StringBuilder();

			hql_.append("select count(p) from Press p where 1=1 ");
			hql.append(" from Press p where 1=1 ");

			StringBuilder whereSub = new StringBuilder();
			/**
			 * 拼接条件 如果某个字段的值不为空，则将作为查询条件
			 */
			if(pressView.getPressISBN()!=null && !"".equals(pressView.getPressISBN())){
				whereSub.append(" and p.pressISBN like (:pressISBN) ");
			}
			if(pressView.getPressName()!=null && !"".equals(pressView.getPressName())){
				whereSub.append(" and p.pressName like (:pressName) ");
			}
			if(pressView.getPressAddress()!=null && !"".equals(pressView.getPressAddress())){
				whereSub.append(" and p.pressAddress like (:pressAddress) ");
			}
			// .......继续拼接........
			hql.append(whereSub);
			hql_.append(whereSub);// count 查询hql拼接结束

			// group by 子句

			// order by 子句

           
			// 查找总记录
			final String hqlIn_ = hql_.toString();
			HibernateCallback callback_ = new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(hqlIn_);
					// 设置查询参数
					if(pressView.getPressISBN()!=null && !"".equals(pressView.getPressISBN())){
						String temp = "%" + pressView.getPressISBN().replace(" ", "%")+"%";
						query.setParameter("pressISBN", temp);
					}
					if(pressView.getPressName()!=null && !"".equals(pressView.getPressName())){
						String temp = "%" + pressView.getPressName().replace(" ", "%")+"%";
						query.setParameter("pressName", temp);
					}
					if(pressView.getPressAddress()!=null && !"".equals(pressView.getPressAddress())){
						String temp = "%" + pressView.getPressAddress().replace(" ", "%")+"%";
						query.setParameter("pressAddress", temp);
					}
					return query.list();
				}

			};
			Long totalCount = (Long) getHibernateTemplate().executeFind(
					callback_).iterator().next();
			// 把记录数设置到view对象中，在action中可取到这个值
			pressView.setTotalCount(totalCount);

			// 查找列表
			final String hqlIn = hql.toString();
			HibernateCallback callback = new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(hqlIn);
					// 判断是否分页
					if (pressView != null && pressView.getIsPage()
							&& pressView.getStart() != null
							&& pressView.getLimit() != null) {
						query.setMaxResults(pressView.getLimit());
						query.setFirstResult(pressView.getStart());
					}
					// //设置查询参数
					if(pressView.getPressISBN()!=null && !"".equals(pressView.getPressISBN())){
						String temp = "%" + pressView.getPressISBN().replace(" ", "%")+"%";
						query.setParameter("pressISBN", temp);
					}
					if(pressView.getPressName()!=null && !"".equals(pressView.getPressName())){
						String temp = "%" + pressView.getPressName().replace(" ", "%")+"%";
						query.setParameter("pressName", temp);
					}
					if(pressView.getPressAddress()!=null && !"".equals(pressView.getPressAddress())){
						String temp = "%" + pressView.getPressAddress().replace(" ", "%")+"%";
						query.setParameter("pressAddress", temp);
					}
					return query.list();
				}

			};
			presses = (List<Press>) getHibernateTemplate()
					.executeFind(callback);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return presses;
	}

	public void insertPressBatch(List<Press> list) throws Exception {
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
