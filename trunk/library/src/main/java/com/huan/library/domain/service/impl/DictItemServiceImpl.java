package com.huan.library.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.book.Category;
import com.huan.library.domain.model.dict.DictItem;
import com.huan.library.domain.service.DictItemService;
import com.huan.library.infrastructure.persistence.DictItemDao;
import com.huan.library.web.view.DictItemView;
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

	public DictItem save(DictItem dictItem) throws Exception {
		DictItem dictItemCopy =null;
		try {
			dictItemCopy = dictItemDao.saveOrUpdate(dictItem);
		} catch (Exception e) {
		    e.printStackTrace();
			return null;
		}
		return dictItemCopy;
	}
	
	public void remove(DictItem dictItem) throws Exception {
		try {
			dictItemDao.delete(dictItem);
		} catch (Exception e) {
           e.printStackTrace();
		}
	}

	public DictItem getById(int dictItemId) throws Exception {
		DictItem dictItem = null;
		try {
			dictItem =  dictItemDao.selectById(dictItemId);			
		} catch (Exception e) {
		  e.printStackTrace();
		  return null;
		}
		return dictItem;
	}

	public List<DictItemView> getByItemClass(String className) throws Exception {
		List<DictItemView> views = new ArrayList<DictItemView>();
		Object o = null;
		try {
			o = Class.forName(className).newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		if (o instanceof DictItem) {
			List<DictItem> dictItems = dictItemDao.getByItemClass(className);
			if (dictItems != null)
				for (DictItem item : dictItems) {
					DictItemView view = new DictItemView();
					view.setKey(item.getItemId() + "");
					view.setValue(item.getItemName());
					view.setComment(item.getItemDesc());
					views.add(view);
				}
		} 
		return views;
	}

	public List<DictItem> getChildrenByPid(String pid, String className) throws Exception  {
		List<DictItem> items = new ArrayList<DictItem>();
		try {
			items = dictItemDao.getChildrenByPid(pid, className);
		} catch (Exception e){
			e.printStackTrace();
		}
		return items;
	}
	
	public List<Category> getCategoryChildrenByPid(String pid, Integer level, String itemName) throws Exception  {
		List<Category> items = new ArrayList<Category>();
		try {
			items = dictItemDao.getCategoryChildrenByPid(pid, level, itemName);
		} catch (Exception e){
			e.printStackTrace();
		}
		return items;
	}

}
