package com.huan.library.infrastructure.persistence.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.rights.Department;
import com.huan.library.infrastructure.persistence.DepartmentDao;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 ����04:55:44
 */
@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements
		DepartmentDao {

	@SuppressWarnings("unchecked")
	public List<Department> selectDeptsByParentId(final Long parentDeptId)
			throws Exception {
		List<Department> depts = new ArrayList<Department>();
		try{
			StringBuilder hql = new StringBuilder();
			hql.append(" from Department d ");
			hql.append(" left join fetch d.parent t_parent ");
			hql.append(" where t_parent.deptId=(:parentDeptId) ");
			final String hqlIn = hql.toString();
			HibernateCallback callback = new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
						Query query = session.createQuery(hqlIn);
						query.setParameter("parentDeptId", parentDeptId);
					return query.list();
				}
			};
			depts = (List<Department>)getHibernateTemplate().executeFind(callback);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return depts;
	}

	public Department selectDeptById(Long deptId) throws Exception {
		StringBuilder hql = new StringBuilder();
		hql.append(" from Department as d " ); 
		hql.append(" where d.deptId=? ");
		Department department = new Department();
		try {
			department = (Department) this.getHibernateTemplate().find(hql.toString(), deptId).listIterator().next();
		} catch (Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return department;
	}

}
