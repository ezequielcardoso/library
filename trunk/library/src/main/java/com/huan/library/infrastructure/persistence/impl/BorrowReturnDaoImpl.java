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

	public BorrowReturn selectBRByBarCode(String barCode) throws Exception {
		BorrowReturn borrowReturn = new BorrowReturn();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" from BorrowReturn br ");
			sql.append(" left join fetch br.book t_b ");
			sql.append(" left join fetch br.reader t_r ");
			sql.append(" where t_b.barCode = ? ");
			borrowReturn = (BorrowReturn)getHibernateTemplate().find(sql.toString(), barCode).listIterator().next();
		} catch (Exception e) {
		  e.printStackTrace();
		  throw new Exception(e);
		}
		return borrowReturn;
	}

	
}
