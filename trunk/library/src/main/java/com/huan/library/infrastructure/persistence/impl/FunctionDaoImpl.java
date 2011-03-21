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

import com.huan.library.domain.model.rights.Function;
import com.huan.library.infrastructure.persistence.FunctionDao;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 下午 04:55:51
 */
@Repository("functionDao")
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements
		FunctionDao {

	public List<Function> selectFunctionsByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertFunctionsBatch(List<Function> functions) throws Exception {
		try {

			SessionFactory sessionFactory = this.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			int i = 0;
			for (Function function : functions) {
				session.save(function);
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

	public List<Function> selectModuleFunctions() throws Exception {
		List<Function> funcs = new ArrayList<Function>();
		try{
			StringBuilder hql = new StringBuilder();
			hql.append(" select new Function( f.funcId, f.funcName, f.funcActive, f.funcOrder, f.level, " +
					"f.resCmpId, f.resCmpText, f.resCmpIconCls, f.resCmpHandURL, p.funcId) "); 
			hql.append(" from Function f " +
					" left join f.parent p ");
			hql.append(" where f.level>0 and f.level<=2 " +
					" order by f.funcOrder ");
			final String hqlIn = hql.toString();
			HibernateCallback callback = new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
						Query query = session.createQuery(hqlIn);
					return query.list();
				}
				
			};
			funcs = (List<Function>)getHibernateTemplate().executeFind(callback);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return funcs;
	}

}
