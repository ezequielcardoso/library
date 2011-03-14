package com.huan.library.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.dict.DictItem;
import com.huan.library.domain.service.DictItemService;
import com.huan.library.infrastructure.persistence.DictItemDao;
/**
 * 字典业务层实现
 * @author huan
 * @time  2011-3-14 上午10:46:18
 */
@Service("dictItemService")
public class DictItemServiceImpl implements DictItemService {

	@Autowired
	private DictItemDao dictItemDao;
	
	public void setDictItemDao(DictItemDao dictItemDao) {
		this.dictItemDao = dictItemDao;
	}

	public DictItem addOrModifyDictItem(DictItem dictItem) throws Exception {
		DictItem dictItemCopy =null;
		try {
			dictItemCopy = dictItemDao.saveOrUpdate(dictItem);
		} catch (Exception e) {
		    e.printStackTrace();
			return null;
		}
		return dictItemCopy;
	}
	
	public void removeDictItem(DictItem dictItem) throws Exception {
		try {
			dictItemDao.delete(dictItem);
		} catch (Exception e) {
           e.printStackTrace();
		}
	}


	public List<DictItem> findAllDictItems() throws Exception {
		List<DictItem> dictItemList = null;
		try {
			dictItemList = dictItemDao.selectAllDictItems();
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
		return dictItemList;
	}

	public DictItem findDictItemById(int dictItemId) throws Exception {
		DictItem dictItem = null;
		try {
			dictItem =  dictItemDao.get(dictItemId);			
		} catch (Exception e) {
		  e.printStackTrace();
		  return null;
		}
		return dictItem;
	}

	
}
