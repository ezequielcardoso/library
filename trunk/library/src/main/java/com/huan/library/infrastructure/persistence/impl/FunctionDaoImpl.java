package com.huan.library.infrastructure.persistence.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.rights.Function;
import com.huan.library.domain.model.rights.User;
import com.huan.library.infrastructure.persistence.FunctionDao;
import com.huan.library.infrastructure.persistence.generic.HibernateDaoSupportBean;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 ����04:55:51
 */
@Repository("functionDao")
public class FunctionDaoImpl extends HibernateDaoSupportBean implements
		FunctionDao {

	public List<Function> selectAllFunctions() {
		return null;
	}

	public List<Function> selectFunctionsByRoleId(String roleId) {
		return null;
	}

	public List<Function> selectModuleFunctions() throws Exception {
		List<Function> funcs = new ArrayList<Function>();
		try{
			StringBuilder hql = new StringBuilder();
			hql.append(" select new Function( f.funcId, f.funcName, f.funcActive, f.funcOrder, f.level, " +
					"f.resCmpId, f.resCmpText, f.resCmpIconCls, f.resCmpHandURL) "); 
			hql.append(" from Function f ");
			hql.append(" where f.level>0 and f.level<=2 ");
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
