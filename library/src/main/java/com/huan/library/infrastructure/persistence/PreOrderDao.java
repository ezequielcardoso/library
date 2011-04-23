package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.domain.model.borrowReturn.PreOrder;
import com.huan.library.web.view.PreOrderView;

public interface PreOrderDao extends BaseDao<PreOrder> {
	
	public List<PreOrder> selectPreOrders(PreOrderView preOrderView) ;

}
