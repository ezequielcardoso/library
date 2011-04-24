package com.huan.library.infrastructure.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.dict.DictItemType;
import com.huan.library.infrastructure.persistence.DictItemTypeDao;

@Repository("dictItemTypeDao")
public class DictItemTypeDaoImp extends BaseDaoImpl<DictItemType> implements
		DictItemTypeDao {

	public List<DictItemType> selectAll() {
		return getHibernateTemplate().find(" from DictItemType type left join fetch root ");
	}

}
