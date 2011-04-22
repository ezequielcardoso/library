package com.huan.library.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.borrowReturn.PreOrder;
import com.huan.library.domain.service.PreOrderService;
import com.huan.library.infrastructure.persistence.PreOrderDao;
import com.huan.library.web.view.PreOrderView;

@Service("preOrderService")
public class PreOrderServiceImpl implements PreOrderService {

	@Autowired
	private PreOrderDao preOrderDao;
	
	public List<PreOrder> findPreOrders(PreOrderView preOrderView)
			throws Exception {
		List<PreOrder> preOrders = new ArrayList<PreOrder>();
		try {
			preOrders = preOrderDao.selectPreOrders(preOrderView);
		} catch (Exception e) {
		  e.printStackTrace();
		  throw new Exception(e);
		}
		return preOrders;
	}

	public void setPreOrderDao(PreOrderDao preOrderDao) {
		this.preOrderDao = preOrderDao;
	}

	public PreOrder save(PreOrder preOrder) throws Exception {
		try {
			preOrder = preOrderDao.saveOrUpdate(preOrder);
		} catch (Exception e) {
		  e.printStackTrace();
		  throw new Exception(e);
		}
		return preOrder;
	}
	
}
