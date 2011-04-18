package com.huan.library.infrastructure.persistence.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.borrowReturn.BorrowReturn;
import com.huan.library.infrastructure.persistence.BorrowReturnDao;
import com.huan.library.web.view.BorrowReturnView;

/**
 * 图书借阅dao实现
 * 
 * @author huan
 * @time 2011-3-17 下午06:31:37
 */
@Repository("borrowReturnDao")
public class BorrowReturnDaoImpl extends BaseDaoImpl<BorrowReturn> implements
		BorrowReturnDao {

	public List<BorrowReturn> selectBorrowReturns(
			final BorrowReturnView borrowReturnView) throws Exception {
		
		List<BorrowReturn> borrowReturns = new ArrayList<BorrowReturn>();
		try {
           StringBuilder sql = new StringBuilder();
           StringBuilder sql_ = new StringBuilder();
           
           sql.append(" select new BorrowReturn( br.id , br.borrowedDate , br.duetoReturnDate , br.realityReturndate , " +
           		"br.overdueDays , br.puniMoney , br.isPay , br.renewTimes , br.borrowOperator , br.returnOperator , t_b.bookId , t_b.bookNo , " +
           		"t_b.barCode , t_b.bookName , t_b.location ,  t_bf.itemId, t_bf.itemCode, t_bf.itemName, " +
           		" t_bs.itemId, t_bs.itemName, t_r.id , t_r.cardNo , t_r.barCode , t_r.readerName , " +
           		" t_ru.unitId, t_ru.unitcode, t_ru.unitName,  t_rt.id, t_rt.readerCateCode, t_rt.readerCateName)");
           sql_.append(" select count(br) ");
           
           sql.append(" from BorrowReturn br ");
           sql_.append(" from BorrowReturn br ");
           
           StringBuilder joinSub = new StringBuilder();
           joinSub.append(" left join br.book t_b ");
           joinSub.append(" left join br.book.firstCategory t_bf ");
           joinSub.append(" left join br.book.bookState t_bs ");
           joinSub.append(" left join br.reader t_r ");
           joinSub.append(" left join br.reader.readerUnits t_ru ");
           joinSub.append(" left join br.reader.readerType t_rt ");
           
           sql.append(joinSub);
           sql_.append(joinSub);
           
           sql.append(" where 1=1 ");
           sql_.append(" where 1=1 ");           
           //fiedls
           
           StringBuilder whereSub = new StringBuilder();
           whereSub.append(" and t_b.isBook = :isBook ");
           if(borrowReturnView.getReaderBarCode()!=null &&!"".equals(borrowReturnView.getReaderBarCode())){
        	   whereSub.append(" and t_r.barCode like (:readerBarCode) ");
           }
           if(borrowReturnView.getReaderName()!=null && !"".equals(borrowReturnView.getReaderName())){
        	   whereSub.append(" and t_r.readerName like (:readerName) ");
           }
           if(borrowReturnView.getUnitName()!=null && !"".equals(borrowReturnView.getUnitName())){
        	   whereSub.append(" and t_ru.unitName like (:unitName) ");
           }
           if(borrowReturnView.getBookBarCode()!=null &&!"".equals(borrowReturnView.getBookBarCode())){
        	   whereSub.append(" and t_b.barCode like (:barCode) ");  
           }
           if(borrowReturnView.getBookName()!=null &&!"".equals(borrowReturnView.getBookName())){
        	   whereSub.append(" and t_b.bookName like (:bookName) ");
           }
           if(borrowReturnView.getFirstCategoryName()!=null &&!"".equals(borrowReturnView.getFirstCategoryName())){
        	   whereSub.append(" and t_bf.itemName like (:firstCategoryName) ");   
           }
           if(borrowReturnView.getBorrowOperator()!=null &&!"".equals(borrowReturnView.getBorrowOperator())){
        	   whereSub.append(" and br.borrowOperator like (:borrowOperator) ");
           }
           if(borrowReturnView.getReturnOperator()!=null &&!"".equals(borrowReturnView.getReturnOperator())){
        	   whereSub.append(" and br.returnOperator like (:returnOperator) ");
           }
           if(borrowReturnView.getBookStateName()!=null && !"".equals(borrowReturnView.getBookStateName())){
        	   whereSub.append(" and t_bs.itemName like (:bookStateName) ");
           }
           sql.append(whereSub);
           sql_.append(whereSub);
           
           final String sqlIn = sql.toString();
           HibernateCallback callback = new HibernateCallback(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(sqlIn);
				query.setParameter("isBook", borrowReturnView.getIsBook());
				String temp = "" ;
				  if(borrowReturnView.getReaderBarCode()!=null &&!"".equals(borrowReturnView.getReaderBarCode())){
					  temp = "%"+borrowReturnView.getReaderBarCode().replace(" ", "%")+"%";  
					  query.setParameter("readerBarCode", temp);
		           }
		           if(borrowReturnView.getReaderName()!=null && !"".equals(borrowReturnView.getReaderName())){
		        	   temp = "%"+borrowReturnView.getReaderName().replace(" ", "%")+"%";  
					   query.setParameter("readerName", temp);
		           }
		           if(borrowReturnView.getUnitName()!=null && !"".equals(borrowReturnView.getUnitName())){
		        	   temp = "%"+borrowReturnView.getUnitName().replace(" ", "%")+"%";  
					   query.setParameter("unitName", temp);
		           }
		           if(borrowReturnView.getBookBarCode()!=null &&!"".equals(borrowReturnView.getBookBarCode())){
		        	   temp = "%"+borrowReturnView.getBookBarCode().replace(" ", "%")+"%";  
					   query.setParameter("barCode", temp);
		           }
		           if(borrowReturnView.getBookName()!=null &&!"".equals(borrowReturnView.getBookName())){
		        	   temp = "%"+borrowReturnView.getBookName().replace(" ", "%")+"%";  
					   query.setParameter("bookName", temp);
		           }
		           if(borrowReturnView.getFirstCategoryName()!=null &&!"".equals(borrowReturnView.getFirstCategoryName())){
		        	   temp = "%"+borrowReturnView.getFirstCategoryName().replace(" ", "%")+"%";  
					   query.setParameter("firstCategoryName", temp);
		           }
		           if(borrowReturnView.getBorrowOperator()!=null &&!"".equals(borrowReturnView.getBorrowOperator())){
		        	   temp = "%"+borrowReturnView.getBorrowOperator().replace(" ", "%")+"%";  
					   query.setParameter("borrowOperator", temp);
		           }
		           if(borrowReturnView.getReturnOperator()!=null &&!"".equals(borrowReturnView.getReturnOperator())){
		        	   temp = "%"+borrowReturnView.getReturnOperator().replace(" ", "%")+"%";  
					   query.setParameter("returnOperator", temp);
		           }
		           if(borrowReturnView.getBookStateName()!=null && !"".equals(borrowReturnView.getBookStateName())){
		        	   temp = "%"+borrowReturnView.getBookStateName().replace(" ", "%")+"%";  
					   query.setParameter("bookStateName", temp);
		           }

				return query.list();
			}
           };
           borrowReturns = (List<BorrowReturn>)getHibernateTemplate().executeFind(callback);
        
           final String sqlIn_ = sql_.toString();
           HibernateCallback callback_ = new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(sqlIn_);
				query.setParameter("isBook", borrowReturnView.getIsBook());
				  String temp = "" ;
				  if(borrowReturnView.getReaderBarCode()!=null &&!"".equals(borrowReturnView.getReaderBarCode())){
					  temp = "%"+borrowReturnView.getReaderBarCode().replace(" ", "%")+"%";  
					  query.setParameter("readerBarCode", temp);
		           }
		           if(borrowReturnView.getReaderName()!=null && !"".equals(borrowReturnView.getReaderName())){
		        	   temp = "%"+borrowReturnView.getReaderName().replace(" ", "%")+"%";  
					   query.setParameter("readerName", temp);
		           }
		           if(borrowReturnView.getUnitName()!=null && !"".equals(borrowReturnView.getUnitName())){
		        	   temp = "%"+borrowReturnView.getUnitName().replace(" ", "%")+"%";  
					   query.setParameter("unitName", temp);
		           }
		           if(borrowReturnView.getBookBarCode()!=null &&!"".equals(borrowReturnView.getBookBarCode())){
		        	   temp = "%"+borrowReturnView.getBookBarCode().replace(" ", "%")+"%";  
					   query.setParameter("barCode", temp);
		           }
		           if(borrowReturnView.getBookName()!=null &&!"".equals(borrowReturnView.getBookName())){
		        	   temp = "%"+borrowReturnView.getBookName().replace(" ", "%")+"%";  
					   query.setParameter("bookName", temp);
		           }
		           if(borrowReturnView.getFirstCategoryName()!=null &&!"".equals(borrowReturnView.getFirstCategoryName())){
		        	   temp = "%"+borrowReturnView.getFirstCategoryName().replace(" ", "%")+"%";  
					   query.setParameter("firstCategoryName", temp);
		           }
		           if(borrowReturnView.getBorrowOperator()!=null &&!"".equals(borrowReturnView.getBorrowOperator())){
		        	   temp = "%"+borrowReturnView.getBorrowOperator().replace(" ", "%")+"%";  
					   query.setParameter("borrowOperator", temp);
		           }
		           if(borrowReturnView.getReturnOperator()!=null &&!"".equals(borrowReturnView.getReturnOperator())){
		        	   temp = "%"+borrowReturnView.getReturnOperator().replace(" ", "%")+"%";  
					   query.setParameter("returnOperator", temp);
		           }
		           if(borrowReturnView.getBookStateName()!=null && !"".equals(borrowReturnView.getBookStateName())){
		        	   temp = "%"+borrowReturnView.getBookStateName().replace(" ", "%")+"%";  
					   query.setParameter("bookStateName", temp);
		           }

				return query.list();
			}
           };
           Long totalCount = (Long)getHibernateTemplate().executeFind(callback_).iterator().next();
           borrowReturnView.setTotalCount(totalCount);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return borrowReturns;

	}
	
	public BorrowReturn selectBRByBookBar(String bookBar) throws Exception {
		BorrowReturn borrowReturn = new BorrowReturn();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" from BorrowReturn br ");
			sql.append(" left join fetch br.book t_b ");
			sql.append(" left join fetch br.reader t_r ");
			sql.append(" where t_b.barCode = ? ");
			borrowReturn = (BorrowReturn) getHibernateTemplate().find(
					sql.toString(), bookBar).listIterator().next();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return borrowReturn;
	}

	public BorrowReturn selectBRByReaderBar(String readerBar) throws Exception {
		BorrowReturn borrowReturn = new BorrowReturn();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" from BorrowReturn br ");
			sql.append(" left join fetch br.book t_b ");
			sql.append(" left join fetch br.reader t_r ");
			sql.append(" where t_r.cardNo = ? ");
			borrowReturn = (BorrowReturn) getHibernateTemplate().find(
					sql.toString(), readerBar).listIterator().next();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return borrowReturn;
	}

	public List<BorrowReturn> selectBorrowReturn(
		 final BorrowReturnView borrowReturnView) throws Exception {
		List<BorrowReturn> borrowReturns = new ArrayList<BorrowReturn>();
		try {
           StringBuilder sql = new StringBuilder();
           
           sql.append(" select new BorrowReturn( br.id , br.borrowedDate , br.duetoReturnDate , br.realityReturndate , " +
           		"br.overdueDays , br.puniMoney , br.isPay , br.renewTimes , br.borrowOperator , br.returnOperator , t_b.bookId , t_b.bookNo , " +
           		"t_b.barCode , t_b.bookName , t_b.location ,  t_bf.itemId, t_bf.itemCode, t_bf.itemName, " +
           		" t_bs.itemId, t_bs.itemName, t_r.id , t_r.cardNo , t_r.barCode , t_r.readerName , " +
           		" t_ru.unitId, t_ru.unitcode, t_ru.unitName,  t_rt.id, t_rt.readerCateCode, t_rt.readerCateName)");
           
           sql.append(" from BorrowReturn br ");
           
           StringBuilder joinSub = new StringBuilder();
           joinSub.append(" left join br.book t_b ");
           joinSub.append(" left join br.book.firstCategory t_bf ");
           joinSub.append(" left join br.book.bookState t_bs ");
           joinSub.append(" left join br.reader t_r ");
           joinSub.append(" left join br.reader.readerUnits t_ru ");
           joinSub.append(" left join br.reader.readerType t_rt ");
           
           sql.append(joinSub);
           
           sql.append(" where 1=1 ");
           
           //fiedls
           StringBuilder whereSub = new StringBuilder();
           whereSub.append(" and t_b.isBook = :isBook ");
           if(borrowReturnView.getBookBarCode()!=null && !"".equals(borrowReturnView.getBookBarCode())){
        	   whereSub.append(" and t_b.barCode = (:bookBarCode) ");
        	   whereSub.append(" and t_bs.itemId = (:bookState) ");
           }
           if(borrowReturnView.getReaderBarCode()!=null && !"".equals(borrowReturnView.getReaderBarCode())){
        	   whereSub.append(" and t_r.barCode = (:readerBarCode) ");
           }
           
           sql.append(whereSub);
           
           final String sqlIn = sql.toString();
           
           HibernateCallback callback = new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(sqlIn);
				query.setParameter("isBook", borrowReturnView.getIsBook());
				if(borrowReturnView.getBookBarCode()!=null &&!"".equals(borrowReturnView.getBookBarCode())){
					query.setParameter("bookBarCode", borrowReturnView.getBookBarCode());
					query.setParameter("bookState", "BookState_JY");
				}
				if(borrowReturnView.getReaderBarCode()!=null &&!"".equals(borrowReturnView.getReaderBarCode())){
					query.setParameter("readerBarCode", borrowReturnView.getReaderBarCode());
				}
				return query.list();
			}
           };
           
           borrowReturns = (List<BorrowReturn>)getHibernateTemplate().executeFind(callback);
           
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return borrowReturns;
	}

	public BorrowReturn selectBRById(Long id) throws Exception {
		BorrowReturn borrowReturn = new BorrowReturn();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" from BorrowReturn br ");
			sql.append(" left join fetch br.book t_b ");
			sql.append(" left join fetch br.reader t_r ");
			sql.append(" left join fetch br.book.bookState t_b_st ");
			sql.append(" where br.id = ? ");
			borrowReturn = (BorrowReturn) getHibernateTemplate().find(
					sql.toString(), id).listIterator().next();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return borrowReturn;
	}

}
