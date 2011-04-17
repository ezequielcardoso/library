package com.huan.library.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.borrowReturn.BorrowReturn;
import com.huan.library.domain.service.BorrowReturnService;
import com.huan.library.infrastructure.persistence.BorrowReturnDao;
import com.huan.library.web.view.BorrowReturnView;
/**
 * 书刊借阅归还service实现
 * @author huan
 * @time  2011-3-17 下午06:36:32
 */
@Service("borrowReturnService")
public class BorrowReturnServiceImpl implements BorrowReturnService {
  
	@Autowired
	private BorrowReturnDao borrowReturnDao;
	
	public BorrowReturn addOrModifyBorrow(BorrowReturn borrowReturn) throws Exception {
		BorrowReturn borrowInfo = new BorrowReturn();
		try {
			borrowInfo = borrowReturnDao.saveOrUpdate(borrowReturn);	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return borrowInfo;
	}

	public BorrowReturn addReturn(BorrowReturn borrowReturn) throws Exception {
		BorrowReturn returnInfo = new BorrowReturn();
		try {
			returnInfo = borrowReturnDao.saveOrUpdate(returnInfo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return returnInfo;
	}
	
	public BorrowReturn getBRByBarCode(String barCode) throws Exception {
		BorrowReturn borrowReturn = new BorrowReturn();
		try {
			borrowReturn = borrowReturnDao.selectBRByBookBar(barCode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return borrowReturn;
	}
	
	public BorrowReturn getBRById(Long id) throws Exception{
		BorrowReturn borrowReturn = new BorrowReturn();
		try {
			borrowReturn = borrowReturnDao.selectBRById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return borrowReturn;
	}
	
	public List<BorrowReturn> getByBarCodeOrReaderCode(BorrowReturnView borrowReturnView) throws Exception{
		List<BorrowReturn> borrowReturns = new ArrayList<BorrowReturn>(); 
		try {
			borrowReturns = borrowReturnDao.selectBorrowReturn(borrowReturnView);
		} catch (Exception e) {
		  e.printStackTrace();
		  throw new Exception(e);
		}
		return borrowReturns;
	}
	
	public void setBorrowReturnDao(BorrowReturnDao borrowReturnDao) {
		this.borrowReturnDao = borrowReturnDao;
	}

}
