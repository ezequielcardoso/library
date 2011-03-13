package com.huan.library.infrastructure.persistence.generic;

import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.dict.DictItem;
/**
 * 数据字典dao实现
 * @author huan
 * @time  2011-3-13 下午07:49:11
 */
@Repository("dictItemDao")
public class DictItemDaoImpl extends HibernateDaoSupportBean implements
		DictItemDao {

	public void saveOrUpdate(DictItem dictItem) throws Exception {
       getHibernateTemplate().saveOrUpdate(dictItem);	
	}

}
