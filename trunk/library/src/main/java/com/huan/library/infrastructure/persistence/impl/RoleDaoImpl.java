package com.huan.library.infrastructure.persistence.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.rights.Role;
import com.huan.library.infrastructure.persistence.RoleDao;
import com.huan.library.web.view.RoleView;

/**
 * 
 * @author shuaizhichun
 * 2010-4-9
 */
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	public List<Role> selectRoles(final RoleView view) throws Exception  {
		List<Role> roles = new ArrayList<Role>();
		try{
			StringBuilder hql = new StringBuilder();
			StringBuilder hql_ = new StringBuilder();
			
			hql_.append("select count(r) from Role r  ");
			hql.append(" from Role r ");//普通查询方式
			
			StringBuilder joinSub = new StringBuilder();
			joinSub.append(" left join fetch r.users as t_user ");//普通查询方式要fetch
			hql.append(joinSub);
			hql_.append(joinSub);
			
			hql.append(" where 1=1 ");
			hql_.append(" where 1=1 ");
			
			StringBuilder whereSub = new StringBuilder();
			if(view.getUserId()!=null && !"".equals(view.getUserId()) 
					&& view.getUserId()!=0){
				whereSub.append("  and t_user.userId=(:userId) ");
			}
			
			hql.append(whereSub);
			hql_.append(whereSub);
			//查找总记录
			final String hqlIn_ = hql_.toString();
			HibernateCallback callback_ = new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
						Query query = session.createQuery(hqlIn_);
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
						if(view!=null && view.getIsPage()
							&& view.getStart()!=null && view.getLimit()!=null){
							query.setMaxResults(view.getLimit());
							query.setFirstResult(view.getStart());
						}
						if(view.getUserId()!=null && !"".equals(view.getUserId()) 
								&& view.getUserId()!=0){
							query.setParameter("userId", view.getUserId());
						}
					return query.list();
				}
				
			};
			roles = getHibernateTemplate().executeFind(callback);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return roles;
	}

	public Role selectById(Long roleId) throws Exception  {
		Role role = new Role();
		try{
			String hql = " from Role r where r.roleId=? ";
			role = (Role) this.getHibernateTemplate().find(hql, roleId).iterator().next();
		}catch(Exception e){
			e.printStackTrace();
		}
		return role;
	}


}
