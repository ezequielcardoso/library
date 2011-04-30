package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.domain.model.borrowReturn.BorrowReturn;
import com.huan.library.web.view.BorrowReturnView;

/**
 * 书刊借阅dao
 * @author huan
 * @time  2011-3-17 下午06:29:36
 */
public interface BorrowReturnDao extends BaseDao<BorrowReturn>{

	/**
	 * 查找借阅记录
	 * @param borrowReturnView
	 * @return
	 * @
	 */
	public List<BorrowReturn> selectBorrowReturns(BorrowReturnView borrowReturnView) ;
	/**
	 * 根据图书条形码查找借阅记录
	 * @param bookBar
	 * @return
	 * @
	 */
	public BorrowReturn selectBRByBookBar(String bookBar) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @
	 */
	public BorrowReturn selectBRById(Long id) ;
	/**
	 * 根据读者条形码查找借阅记录
	 * @param readerBar
	 * @return
	 * @
	 */
	public BorrowReturn selectBRByReaderBar(String readerBar) ;
	/**
	 * 根据读者条形码/读者条形码查找借阅记录
	 * @param borrowReturnView
	 * @return
	 * @
	 */
	public List<BorrowReturn> selectBorrowReturn(BorrowReturnView borrowReturnView) ;
	/**
	 * 查找将要逾期的记录
	 * @return
	 */
	public List<BorrowReturn> aboutToDueBorrowReturn() ;
}
