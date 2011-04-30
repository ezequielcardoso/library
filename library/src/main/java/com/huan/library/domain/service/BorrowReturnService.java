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
	 * @
	 */
	public BorrowReturn addOrModifyBorrow(BorrowReturn borrowReturn)
			;

	/**
	 * 添加一条归还记录
	 * 
	 * @param borrowReturn
	 * @return
	 * @
	 */
	public BorrowReturn addReturn(BorrowReturn borrowReturn) ;

	public BorrowReturn getBRByBarCode(String barCode) ;

	public BorrowReturn getBRById(Long id) ;

	/**
	 * 根据读者条形码和图书条形码查找借阅记录
	 * 
	 * @param borrowReturnView
	 * @return
	 * @
	 */
	public List<BorrowReturn> getByBarCodeOrReaderCode(
			BorrowReturnView borrowReturnView) ;

	/**
	 * 
	 * @param borrowReturnView
	 * @return
	 * @
	 */
	public List<BorrowReturn> findBorrowReturns(BorrowReturnView borrowReturnView);
	/**
	 * 查找将要逾期的记录
	 * @return
	 */
	public List<BorrowReturn> aboutToDueBorrowReturns();
    
	/**
	 * 导出Excel
	 * @param rootDir
	 * @param borrowReturnView
	 * @return
	 * @
	 */
	public String exportExcel(String rootDir, BorrowReturnView borrowReturnView) ;
}
