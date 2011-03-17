package com.huan.library.infrastructure.persistence.impl;


import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.borrowReturn.BorrowReturn;
import com.huan.library.infrastructure.persistence.BorrowReturnDao;
/**
 * 图书借阅dao实现
 * @author huan
 * @time  2011-3-17 下午06:31:37
 */
@Repository("borrowReturnDao")
public class BorrowReturnDaoImpl extends BaseDaoImpl<BorrowReturn> implements
		BorrowReturnDao {

	
}
