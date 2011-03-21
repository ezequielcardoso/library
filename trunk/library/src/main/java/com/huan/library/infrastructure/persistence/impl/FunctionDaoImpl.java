package com.huan.library.infrastructure.persistence.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

	public List<Function> selectAllFunctions() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Function> selectModuleFunctions() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
