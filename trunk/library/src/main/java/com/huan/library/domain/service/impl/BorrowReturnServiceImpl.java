package com.huan.library.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.borrowReturn.BorrowReturn;
import com.huan.library.domain.service.BorrowReturnService;
import com.huan.library.infrastructure.persistence.BorrowReturnDao;
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
		}
		return borrowInfo;
	}

	public BorrowReturn addReturn(BorrowReturn borrowReturn) throws Exception {
		BorrowReturn returnInfo = new BorrowReturn();
		try {
			returnInfo = borrowReturnDao.saveOrUpdate(returnInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return returnInfo;
	}
	
	public void setBorrowReturnDao(BorrowReturnDao borrowReturnDao) {
		this.borrowReturnDao = borrowReturnDao;
	}

}
