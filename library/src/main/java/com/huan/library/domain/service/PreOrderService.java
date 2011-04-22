package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.domain.model.borrowReturn.PreOrder;
import com.huan.library.web.view.PreOrderView;

/**
 * 预约
 * @author Administrator
 *
 */
public interface PreOrderService {

	public List<PreOrder> findPreOrders(PreOrderView preOrderView) throws Exception;
	
	public PreOrder save(PreOrder preOrder) throws Exception;
	
}
