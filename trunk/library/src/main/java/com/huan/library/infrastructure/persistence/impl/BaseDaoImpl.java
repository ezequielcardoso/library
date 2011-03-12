package com.huan.library.infrastructure.persistence.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.huan.library.infrastructure.persistence.BaseDao;
import com.huan.library.infrastructure.persistence.generic.HibernateDaoSupportBean;
/**
 * 抽象BaseDao实现
 * @author huan
 * @time  2011-3-12 下午06:57:07
 */
public abstract class BaseDaoImpl<T> extends HibernateDaoSupportBean implements BaseDao<T>{

	/**
	 * 得到子类的实体对象
	 */
	protected Class<T> entityClass = getEntityClass();
	
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
	
	public T saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
		return t;
	}

	public void delete(T t) {
	    getHibernateTemplate().delete(t);	
	}

	public T get(Serializable entityId) {
        return getHibernateTemplate().load(entityClass, entityId);
	}

	    
}
