package com.huan.library.domain.service;

import com.huan.library.domain.model.borrowReturn.BorrowReturn;

/**
 * 图书归还service
 * @author Administrator
 * @time  2011-3-17 下午06:33:02
 */
public interface BorrowReturnService {
	/**
	 * 添加一条借阅记录 修改就是续借
	 * @param borrowReturn
	 * @return
	 * @throws Exception
	 */
	public BorrowReturn addOrModifyBorrow(BorrowReturn borrowReturn) throws Exception;
	/**
	 * 添加一条归还记录
	 * @param borrowReturn
	 * @return
	 * @throws Exception
	 */
	public BorrowReturn addReturn(BorrowReturn borrowReturn) throws Exception;

}
