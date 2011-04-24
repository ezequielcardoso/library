package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.domain.model.dict.DictItemType;

public interface DictItemTypeDao extends BaseDao<DictItemType> {

	public List<DictItemType> selectAll() ;
}
