package com.huan.library.infrastructure.persistence.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.huan.library.constant.LoginState;
import com.huan.library.domain.model.rights.User;
import com.huan.library.infrastructure.persistence.UserDao;
import com.huan.library.web.view.UserView;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 时间 04:56:04
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public LoginState getUserLoginState(User user) throws Exception {
		String hql = "select count(o) from User o where ( o.userName=? or o.userAccount=? ) and o.password=? and o.userActive = ?";
		Long count = 0L;
		try {
			count = (Long) getHibernateTemplate().find(hql,
					user.getUserName(), user.getUserName(), user.getPassword(), true).listIterator().next();
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		if (count == 0 ) {
			return LoginState.ERROR_PWD_USER;
		} else {
			return LoginState.PASS;
		}
	}

	public User getUserRole(User sysUser)  throws Exception {
		String hql = " from User as user left join fetch user.roles as r " +
			" where (user.userName=? or user.userAccount=?) and r.roleActive = ?";
		User user = new User();
		try {
			List users = this.getHibernateTemplate().find(hql, sysUser.getUserName(), sysUser.getUserName(), true);
			if(users!=null && !users.isEmpty()){
				user = (User)users.listIterator().next();
			}
		} catch (Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return user;
	}
	
	public User selectUserById(Long userId) throws Exception{
		User user = new User();
		try{
			String hql = " from User u where u.userId=? ";
			user = (User) this.getHibernateTemplate().find(hql, userId).iterator().next();
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}

	public List<User> selectUsers(final UserView view) throws Exception {
		List<User> users = new ArrayList<User>();
		try{
			StringBuilder hql = new StringBuilder();
			StringBuilder hql_ = new StringBuilder();
			
			hql_.append("select count(u) from User u  ");
//			hql.append(" select new User(u.userId, u.userAccount, u.userName, u.password, u.userActive," + 
//					" u.createDate, t_dept.deptId, t_dept.deptName) from User u ");//构造器查询方式
			hql.append(" from User u ");//普通查询方式
			
			StringBuilder joinSub = new StringBuilder();
//			joinSub.append(" left join u.dept t_dept ");//构造器查询方式不用fetch
			joinSub.append(" left join fetch u.dept t_dept ");//普通查询方式要fetch
			
			hql.append(joinSub);
			
			hql.append(" where 1=1 ");
			hql_.append(" where 1=1 ");
			
			StringBuilder whereSub = new StringBuilder();
			if(view.getDeptId()!=null && !"".equals(view.getDeptId())){
				whereSub.append("  and u.dept.deptId=(:deptId) ");
			}
			if(view.getDeptName()!=null && !"".equals(view.getDeptName())){
				whereSub.append(" and  u.dept.deptName=(:deptName) ");
			}
			if(view.getUserName()!=null && !"".equals(view.getUserName())){
				whereSub.append(" and  u.userName=(:userName) ");
			}
			hql.append(whereSub);
			hql_.append(whereSub);
			//查找总记录
			final String hqlIn_ = hql_.toString();
			HibernateCallback callback_ = new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
						Query query = session.createQuery(hqlIn_);
						if(view.getDeptId()!=null && !"".equals(view.getDeptId())){
							query.setParameter("deptId", view.getDeptId());
						}
						if(view.getDeptName()!=null && !"".equals(view.getDeptName())){
							query.setParameter("deptName", view.getDeptName());
						}
						if(view.getUserName()!=null && !"".equals(view.getUserName())){
							query.setParameter("userName", view.getUserName());
						}
					return query.list();
				}
				
			};
			Long totalCount  = (Long) getHibernateTemplate().executeFind(callback_).iterator().next();
			view.setTotalCount(totalCount);
			
			//查找列表
			final String hqlIn = hql.toString();
			HibernateCallback callback = new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
						Query query = session.createQuery(hqlIn);
						//判断是否分页
						if(view!=null && view.getIsPage()){
							query.setMaxResults(view.getLimit());
							query.setFirstResult(view.getStart());
						}
						if(view.getDeptId()!=null && !"".equals(view.getDeptId())){
							query.setParameter("deptId", view.getDeptId());
						}
						if(view.getDeptName()!=null && !"".equals(view.getDeptName())){
							query.setParameter("deptName", view.getDeptName());
						}
						if(view.getUserName()!=null && !"".equals(view.getUserName())){
							query.setParameter("userName", view.getUserName());
						}
					return query.list();
				}
				
			};
			users = getHibernateTemplate().executeFind(callback);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return users;
	}
}
