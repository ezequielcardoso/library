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
	 * 根据图书条形码查找借阅记录
	 * @param bookBar
	 * @return
	 * @throws Exception
	 */
	public BorrowReturn selectBRByBookBar(String bookBar) throws Exception;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BorrowReturn selectBRById(Long id) throws Exception;
	/**
	 * 根据读者条形码查找借阅记录
	 * @param readerBar
	 * @return
	 * @throws Exception
	 */
	public BorrowReturn selectBRByReaderBar(String readerBar) throws Exception;
	/**
	 * 根据读者条形码/读者条形码查找借阅记录
	 * @param borrowReturnView
	 * @return
	 * @throws Exception
	 */
	public List<BorrowReturn> selectBorrowReturn(BorrowReturnView borrowReturnView) throws Exception; 
}
