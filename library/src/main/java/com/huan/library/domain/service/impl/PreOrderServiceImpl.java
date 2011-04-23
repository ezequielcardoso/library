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
			 {
		return preOrderDao.selectPreOrders(preOrderView);
	}

	public void setPreOrderDao(PreOrderDao preOrderDao) {
		this.preOrderDao = preOrderDao;
	}

	public PreOrder save(PreOrder preOrder)  {
		return preOrderDao.saveOrUpdate(preOrder);
	}
	
}
