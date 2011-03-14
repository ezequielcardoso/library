package com.huan.library.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.book.Press;
import com.huan.library.domain.service.PressService;
import com.huan.library.infrastructure.persistence.generic.PressDao;
@Service("pressService")
public class PressServiceImpl implements PressService {

	@Autowired
	private PressDao pressDao;
	
	public PressDao getPressDao() {
		return pressDao;
	}

	public void setPressDao(PressDao pressDao) {
		this.pressDao = pressDao;
	}

	public void addOrModifyPress(Press press) throws Exception {
		 pressDao.saveOrUpdate(press);
	}

	public List<Press> findAllPresses() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

		public void removePress(Press press) throws Exception {
	    pressDao.delete(press);
	}

	public Press findPressById(int pressId) throws Exception {
		return pressDao.get(pressId);
	}

	
}
