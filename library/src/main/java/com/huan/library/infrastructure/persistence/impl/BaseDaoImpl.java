package com.huan.library.infrastructure.persistence.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.huan.library.infrastructure.persistence.BaseDao;
import com.huan.library.infrastructure.persistence.generic.HibernateDaoSupportBean;
import com.huan.library.util.PageModel;
/**
 * 抽象BaseDao实现
 * @author huan
 * @time  2011-3-12 下午06:57:07
 */
public class BaseDaoImpl<T> extends HibernateDaoSupportBean implements BaseDao<T>{

	/**
	 * 得到子类的实体对象
	 */
	protected Class<T> entityClass = getEntityClass();
	/**
	 * 得到实体的名称
	 */
	private String entityName = getEntityName();
	
	@SuppressWarnings("unchecked")
	private Class<T> getEntityClass(){
	      //得到运行期的类的父类
		  Type parentType = getClass().getGenericSuperclass();
	        //判断该类是不是泛型
		  if(parentType instanceof ParameterizedType){
	    	  ParameterizedType pType = (ParameterizedType)parentType;
	    	  //得到泛型中的参数
	    	  return (Class<T>)pType.getActualTypeArguments()[0];
	      }
	      return null;
	}
	/**
	 * 得到实体的名称
	 * @return
	 */
	private String getEntityName(){
		String entityName = entityClass.getSimpleName();
		Entity entity = entityClass.getAnnotation(Entity.class);
		if(entity.name()!=null && entity.name()!=""){
			entityName = entity.name();
		}
		return entityName;
	}
	
	public T saveOrUpdate(T t) throws Exception{
		try{
			getHibernateTemplate().saveOrUpdate(t);
		} catch(Exception e){
			e.printStackTrace();
		}
		return t;
	}

	public void delete(T t) throws Exception{
		try{
			getHibernateTemplate().delete(t);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public T selectById(Serializable entityId) throws Exception{
		  T t = null; 
		try{
			t = getHibernateTemplate().load(entityClass, entityId);
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return t;
	}
    
	@SuppressWarnings("unchecked")
	public List<T> selectSmallTs() throws Exception {
		List<T> ts = new ArrayList<T>();
		try {
		 ts = getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				return	session.createQuery("from " +entityClass.getName())
				.list();
			}
		 })	;		
		} catch (Exception e) {
            e.printStackTrace();
            return null;
		}
		return ts;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> selectMaxTs() throws Exception {
		List<T> list = new ArrayList<T>();
		try {
			list = (List<T>) getHibernateTemplate().find("from "+ entityClass.getName());
		} catch (Exception e) {
		  e.printStackTrace();
		  return null;
 		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public PageModel<T> selectByPage(final int pageNo, final int pageSize) throws Exception {
		PageModel<T> pageModel = new PageModel<T>();
		List<T> resultList = new ArrayList<T>();
		try {
			resultList = getHibernateTemplate().executeFind(new HibernateCallback(){
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					return session.createQuery("from "+entityClass.getName()+" order by id")
					    .setFirstResult(pageNo)
					    .setMaxResults(pageSize).list();
				}
				
			});
			pageModel.setPageNo(pageNo);
			pageModel.setPageSize(pageSize);
			pageModel.setTotalRecords(selectTotalRecords());
			pageModel.setRestleList(resultList);
		} catch (Exception e) {
		   e.printStackTrace();
		   return null;
		}
		return pageModel;
	}
	/**
	 * 查询总的记录数
	 * @return
	 * @throws Exception
	 */
	private Long selectTotalRecords() throws Exception {
//        return (Long) this.getSession().createQuery("select count(*) from :entity")
//        .setParameter("entity", entityClass.getName())
//        .uniqueResult();
//        上面的东西怎么实现不了
		return (Long) getSession().createQuery("select count(*) from " + entityClass.getName())
		                    .uniqueResult();
	}	
}