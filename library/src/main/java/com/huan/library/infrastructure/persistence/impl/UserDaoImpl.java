package com.huan.library.infrastructure.persistence.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.rights.User;
import com.huan.library.infrastructure.persistence.UserDao;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 时间 04:56:04
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@SuppressWarnings("unchecked")
	public List<User> selectAllUsers() throws Exception{
		List<User> users = new ArrayList<User>();
		try{
			String hql = "from User ";
			users = this.getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return users;
	}

	public List<User> selectUsersByDeptId(final String deptId) throws Exception {
		List<User> users = new ArrayList<User>();
		try{
			StringBuilder hql = new StringBuilder();
			hql.append(" select new User( u.userId, u.userAccount, u.userName, u.password, u.userActive, u.createDate, t_dept.deptId, t_dept.deptName) "); 
			hql.append(" from User u ");
			hql.append(" where t_dept.deptId=(:deptId) ");
			hql.append(" left join u.dept t_dept ");
			final String hqlIn = hql.toString();
			HibernateCallback callback = new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
						Query query = session.createQuery(hqlIn);
						query.setParameter("deptId", deptId);
					return query.list();
				}
				
			};
			users = (List<User>)getHibernateTemplate().executeFind(callback);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return users;
	}
}
