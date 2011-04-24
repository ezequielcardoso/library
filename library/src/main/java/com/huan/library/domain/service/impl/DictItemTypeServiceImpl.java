package com.huan.library.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.dict.DictItemType;
import com.huan.library.domain.service.DictItemTypeService;
import com.huan.library.infrastructure.persistence.DictItemTypeDao;

@Service("dictItemTypeService")
public class DictItemTypeServiceImpl implements DictItemTypeService {

	@Autowired
	private DictItemTypeDao dictItemTypeDao;
	
	public void setDictItemTypeDao(DictItemTypeDao dictItemTypeDao) {
		this.dictItemTypeDao = dictItemTypeDao;
	}

	public List<DictItemType> findAll() {
		return this.dictItemTypeDao.selectAll();
	}

}
