package com.huan.library.infrastructure.persistence;

import com.huan.library.domain.model.borrowReturn.BorrowReturn;

/**
 * 书刊借阅dao
 * @author huan
 * @time  2011-3-17 下午06:29:36
 */
public interface BorrowReturnDao extends BaseDao<BorrowReturn>{

	/**
	 * 根据条形码查找借阅记录
	 * @param barCode
	 * @return
	 * @throws Exception
	 */
	public BorrowReturn selectBRByBarCode(String barCode) throws Exception;
	
}
