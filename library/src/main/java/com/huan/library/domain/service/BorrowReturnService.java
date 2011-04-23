package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.borrowReturn.BorrowReturn;
import com.huan.library.web.view.BookView;
import com.huan.library.web.view.BorrowReturnView;

/**
 * 图书归还service
 * 
 * @author Administrator
 * @time 2011-3-17 下午06:33:02
 */
public interface BorrowReturnService {
	/**
	 * 添加一条借阅记录 修改就是续借
	 * 
	 * @param borrowReturn
	 * @return
	 * @throws Exception
	 */
	public BorrowReturn addOrModifyBorrow(BorrowReturn borrowReturn)
			throws Exception;

	/**
	 * 添加一条归还记录
	 * 
	 * @param borrowReturn
	 * @return
	 * @throws Exception
	 */
	public BorrowReturn addReturn(BorrowReturn borrowReturn) throws Exception;

	public BorrowReturn getBRByBarCode(String barCode) throws Exception;

	public BorrowReturn getBRById(Long id) throws Exception;

	/**
	 * 根据读者条形码和图书条形码查找借阅记录
	 * 
	 * @param borrowReturnView
	 * @return
	 * @throws Exception
	 */
	public List<BorrowReturn> getByBarCodeOrReaderCode(
			BorrowReturnView borrowReturnView) throws Exception;

	/**
	 * 
	 * @param borrowReturnView
	 * @return
	 * @throws Exception
	 */
	public List<BorrowReturn> findBorrowReturns(BorrowReturnView borrowReturnView)
			throws Exception;
    
	/**
	 * 导出Excel
	 * @param rootDir
	 * @param borrowReturnView
	 * @return
	 * @throws Exception
	 */
	public String exportExcel(String rootDir, BorrowReturnView borrowReturnView) throws Exception;
}
