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
import com.huan.library.domain.model.rights.Role;
import com.huan.library.domain.model.rights.User;
import com.huan.library.infrastructure.persistence.FunctionDao;
import com.huan.library.web.view.FunctionView;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 下午 04:55:51
 */
@Repository("functionDao")
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements
		FunctionDao {

	public List<Function> selectByRoleId(final FunctionView functionView) {
		final String getHql = "from Function func left join fetch func.roles as roles where roles.roleId = :roleId ";
		List executeFind = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session s)
							throws HibernateException, SQLException {
						Query query = s.createQuery(getHql);
						query.setParameter("roleId", functionView.getRoleId());
						return query.list();
					}
				});
		return executeFind;
	}

	public void insertFunctionsBatch(List<Function> functions) {

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

	}

	public List<Function> selectModules(final List<Role> roles) {
		List<Function> functions = new ArrayList<Function>();
		List<Integer> roleIds = new ArrayList<Integer>();
		if(roles.size()>0){
			for(Role role : roles){
				roleIds.add(role.getRoleId());
			}
			
			final List<Integer> roleIdList = roleIds;
			StringBuilder hql = new StringBuilder();
			hql.append(" from Function f left join fetch f.roles roles ");
			hql.append(" where f.level>0 and f.level<=2 and f.funcActive=(:funcActive) and roles.roleId in (:roleIds)"
					+ " order by f.funcOrder ");
			final String hqlIn = hql.toString();
			functions = getHibernateTemplate().executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(hqlIn);
					query.setBoolean("funcActive", true);
					query.setParameterList("roleIds", roleIdList);
					return query.list();
				}

			});
		}
		return functions;
	}

	public List<Function> selectFunctions(FunctionView functionView) {
		String hql = "from Function func ";
		if (functionView.getParentId() != null
				&& !"".equals(functionView.getParentId())) {
			hql += "where func.parentFuncId = '" + functionView.getParentId()
					+ "' order by func.level,func.funcOrder";
		} else {
			hql += "where func.level = 1 order by func.funcOrder";
		}
		List<Function> executeFind = getHibernateTemplate().find(hql);
		return executeFind;
	}

	public List<Function> selectAll() {
		return getHibernateTemplate().find("from Function func ");
	}

	public Function getById(Function func) {
		String hql = " from Function fun left join fetch fun.parent left join fetch fun.children where fun.funcId=?";
		Function executeFind = (Function) getHibernateTemplate().find(hql, func.getFuncId()).listIterator().next();
		return executeFind;
	}

}
