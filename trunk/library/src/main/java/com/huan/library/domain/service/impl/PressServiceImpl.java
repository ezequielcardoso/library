package com.huan.library.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.book.Press;
import com.huan.library.domain.service.PressService;
import com.huan.library.infrastructure.persistence.PressDao;
import com.huan.library.util.PageModel;
import com.huan.library.web.view.PressView;

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

	public Press addOrModifyPress(Press press) throws Exception {
		Press pressCopy = new Press();
		try {
			pressCopy = pressDao.saveOrUpdate(press);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return pressCopy;
	}

	public List<Press> findAllPresses() throws Exception {
		List<Press> presses = new ArrayList<Press>();
		try {
			presses = pressDao.selectMaxTs();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return presses;
	}

	public void removePress(Press press) throws Exception {
		try{
		   pressDao.delete(press);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Press findPressById(Long pressId) throws Exception {
		Press pressCopy = new Press();
		try {
			pressCopy = pressDao.selectById(pressId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return pressCopy;
	}

	public PageModel<Press> findPressesByPage(int pageNo, int pageSize)
			throws Exception {
		PageModel<Press> pageModel = new PageModel<Press>();
		try {
			pageModel = pressDao.selectByPage(pageNo, pageSize);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return pageModel;
	}

	public List<Press> findPresses(PressView pressView) throws Exception{
		return null;
	}
}
