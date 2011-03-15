package com.huan.library.infrastructure.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.dict.DictItem;
import com.huan.library.infrastructure.persistence.DictItemDao;
/**
 * 数据字典dao实现
 * @author huan
 * @time  2011-3-13 下午07:49:11
 */
@Repository("dictItemDao")
public class DictItemDaoImpl extends BaseDaoImpl<DictItem>  implements
		DictItemDao {

	public List<DictItem> selectAllDictItems() throws Exception {
		List<DictItem> DictItemList = null;
		try {
			DictItemList = getHibernateTemplate().find("from DictItem");
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
		return DictItemList;
	}

	public List<DictItem> getDictItemMapbyItemClass(String className) {
		String hql = " from " + className;
		return  this.getHibernateTemplate().find(hql);
	}

	
}
