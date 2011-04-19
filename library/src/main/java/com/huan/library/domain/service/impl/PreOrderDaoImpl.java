package com.huan.library.domain.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.borrowReturn.PreOrder;
import com.huan.library.infrastructure.persistence.PreOrderDao;
import com.huan.library.infrastructure.persistence.impl.BaseDaoImpl;
import com.huan.library.web.view.PreOrderView;

@Repository("preOrderDao")
public class PreOrderDaoImpl extends BaseDaoImpl<PreOrder> implements PreOrderDao {

	public List<PreOrder> selectPreOrders(final PreOrderView preOrderView)
			throws Exception {
		List<PreOrder> preOrders = new ArrayList<PreOrder>();
		try {
           StringBuilder sql = new StringBuilder();
           StringBuilder sql_ = new StringBuilder();
           
           sql.append(" select new PreOrder( pr.id , pr.preOrderDate , pr.preOrderEndDate , " +
           		" t_b.bookId , t_b.bookNo , t_b.barCode , t_b.bookName , t_b.location ,  t_bf.itemId, t_bf.itemCode, t_bf.itemName, " +
           		" t_bs.itemId, t_bs.itemName, t_r.id , t_r.cardNo , t_r.barCode , t_r.readerName , " +
           		" t_ru.unitId, t_ru.unitcode, t_ru.unitName,  t_rt.id, t_rt.readerCateCode, t_rt.readerCateName)");
           sql_.append(" select count(pr) ");
           
           sql.append(" from PreOrder pr ");
           sql_.append(" from PreOrder pr ");
           
           StringBuilder joinSub = new StringBuilder();
           joinSub.append(" left join pr.book t_b ");
           joinSub.append(" left join pr.book.firstCategory t_bf ");
           joinSub.append(" left join pr.book.bookState t_bs ");
           joinSub.append(" left join pr.reader t_r ");
           joinSub.append(" left join pr.reader.readerUnits t_ru ");
           joinSub.append(" left join pr.reader.readerType t_rt ");
           
           sql.append(joinSub);
           sql_.append(joinSub);
           
           sql.append(" where 1=1 ");
           sql_.append(" where 1=1 ");           
           //fiedls
           
           StringBuilder whereSub = new StringBuilder();
           whereSub.append(" and t_b.isBook = :isBook ");
           if(preOrderView.getReaderBarCode()!=null &&!"".equals(preOrderView.getReaderBarCode())){
        	   whereSub.append(" and t_r.barCode like (:readerBarCode) ");
           }
           if(preOrderView.getReaderName()!=null && !"".equals(preOrderView.getReaderName())){
        	   whereSub.append(" and t_r.readerName like (:readerName) ");
           }
           if(preOrderView.getUnitName()!=null && !"".equals(preOrderView.getUnitName())){
        	   whereSub.append(" and t_ru.unitName like (:unitName) ");
           }
           if(preOrderView.getBookBarCode()!=null &&!"".equals(preOrderView.getBookBarCode())){
        	   whereSub.append(" and t_b.barCode like (:barCode) ");  
           }
           if(preOrderView.getBookName()!=null &&!"".equals(preOrderView.getBookName())){
        	   whereSub.append(" and t_b.bookName like (:bookName) ");
           }
           if(preOrderView.getFirstCategoryName()!=null &&!"".equals(preOrderView.getFirstCategoryName())){
        	   whereSub.append(" and t_bf.itemName like (:firstCategoryName) ");   
           }
           if(preOrderView.getPreOrderDate()!=null && preOrderView.getEndPreOrderDate()==null){
				whereSub.append(" and pr.preOrderDate =(:preOrderDate) ");
			}
			if(preOrderView.getPreOrderDate()==null && preOrderView.getEndPreOrderDate()!=null){
				whereSub.append(" and pr.preOrderDate =(:endPreOrderDate) ");
			}
			if(preOrderView.getPreOrderDate()!=null && preOrderView.getEndPreOrderDate()!=null){
				whereSub.append(" and pr.preOrderDate between (:preOrderDate) and (:endPreOrderDate) ");
			}
			if(preOrderView.getPreOrderEndDate()!=null && preOrderView.getEndPreOrderEndDate()==null){
				whereSub.append(" and pr.preOrderEndDate =(:preOrderEndDate) ");
			}
			if(preOrderView.getPreOrderEndDate()==null && preOrderView.getEndPreOrderEndDate()!=null){
				whereSub.append(" and pr.preOrderEndDate =(:endPreOrderEndDate) ");
			}
			if(preOrderView.getPreOrderEndDate()!=null && preOrderView.getEndPreOrderEndDate()!=null){
				whereSub.append(" and pr.preOrderEndDate between (:preOrderEndDate) and (:endPreOrderEndDate) ");
			}
           sql.append(whereSub);
           sql_.append(whereSub);
           
           final String sqlIn = sql.toString();
           HibernateCallback callback = new HibernateCallback(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(sqlIn);
				query.setParameter("isBook", preOrderView.getIsBook());
				String temp = "" ;
				  if(preOrderView.getReaderBarCode()!=null &&!"".equals(preOrderView.getReaderBarCode())){
					  temp = "%"+preOrderView.getReaderBarCode().replace(" ", "%")+"%";  
					  query.setParameter("readerBarCode", temp);
		           }
		           if(preOrderView.getReaderName()!=null && !"".equals(preOrderView.getReaderName())){
		        	   temp = "%"+preOrderView.getReaderName().replace(" ", "%")+"%";  
					   query.setParameter("readerName", temp);
		           }
		           if(preOrderView.getUnitName()!=null && !"".equals(preOrderView.getUnitName())){
		        	   temp = "%"+preOrderView.getUnitName().replace(" ", "%")+"%";  
					   query.setParameter("unitName", temp);
		           }
		           if(preOrderView.getBookBarCode()!=null &&!"".equals(preOrderView.getBookBarCode())){
		        	   temp = "%"+preOrderView.getBookBarCode().replace(" ", "%")+"%";  
					   query.setParameter("barCode", temp);
		           }
		           if(preOrderView.getBookName()!=null &&!"".equals(preOrderView.getBookName())){
		        	   temp = "%"+preOrderView.getBookName().replace(" ", "%")+"%";  
					   query.setParameter("bookName", temp);
		           }
		           if(preOrderView.getFirstCategoryName()!=null &&!"".equals(preOrderView.getFirstCategoryName())){
		        	   temp = "%"+preOrderView.getFirstCategoryName().replace(" ", "%")+"%";  
					   query.setParameter("firstCategoryName", temp);
		           }
		           if(preOrderView.getPreOrderDate()!=null && preOrderView.getEndPreOrderDate()==null){
						query.setParameter("preOrderDate", preOrderView.getPreOrderDate());
					}
					if(preOrderView.getPreOrderDate()==null && preOrderView.getEndPreOrderDate()!=null){
						query.setParameter("endPreOrderDate", preOrderView.getEndPreOrderDate());
					}
					if(preOrderView.getPreOrderDate()!=null && preOrderView.getEndPreOrderDate()!=null){
						query.setParameter("preOrderDate", preOrderView.getPreOrderDate());
						query.setParameter("endPreOrderDate", preOrderView.getEndPreOrderDate());
					}
					if(preOrderView.getPreOrderEndDate()!=null && preOrderView.getEndPreOrderEndDate()==null){
						query.setParameter("preOrderEndDate", preOrderView.getPreOrderEndDate());
					}
					if(preOrderView.getPreOrderEndDate()==null && preOrderView.getEndPreOrderEndDate()!=null){
						query.setParameter("endPreOrderEndDate", preOrderView.getPreOrderEndDate());
					}
					if(preOrderView.getPreOrderEndDate()!=null && preOrderView.getEndPreOrderEndDate()!=null){
						query.setParameter("preOrderEndDate", preOrderView.getPreOrderEndDate());
						query.setParameter("endPreOrderEndDate", preOrderView.getEndPreOrderEndDate());
					}
				return query.list();
			}
           };
           preOrders = (List<PreOrder>)getHibernateTemplate().executeFind(callback);
        
           final String sqlIn_ = sql_.toString();
           HibernateCallback callback_ = new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(sqlIn_);
				query.setParameter("isBook", preOrderView.getIsBook());
				  String temp = "" ;
				  if(preOrderView.getReaderBarCode()!=null &&!"".equals(preOrderView.getReaderBarCode())){
					  temp = "%"+preOrderView.getReaderBarCode().replace(" ", "%")+"%";  
					  query.setParameter("readerBarCode", temp);
		           }
		           if(preOrderView.getReaderName()!=null && !"".equals(preOrderView.getReaderName())){
		        	   temp = "%"+preOrderView.getReaderName().replace(" ", "%")+"%";  
					   query.setParameter("readerName", temp);
		           }
		           if(preOrderView.getUnitName()!=null && !"".equals(preOrderView.getUnitName())){
		        	   temp = "%"+preOrderView.getUnitName().replace(" ", "%")+"%";  
					   query.setParameter("unitName", temp);
		           }
		           if(preOrderView.getBookBarCode()!=null &&!"".equals(preOrderView.getBookBarCode())){
		        	   temp = "%"+preOrderView.getBookBarCode().replace(" ", "%")+"%";  
					   query.setParameter("barCode", temp);
		           }
		           if(preOrderView.getBookName()!=null &&!"".equals(preOrderView.getBookName())){
		        	   temp = "%"+preOrderView.getBookName().replace(" ", "%")+"%";  
					   query.setParameter("bookName", temp);
		           }
		           if(preOrderView.getFirstCategoryName()!=null &&!"".equals(preOrderView.getFirstCategoryName())){
		        	   temp = "%"+preOrderView.getFirstCategoryName().replace(" ", "%")+"%";  
					   query.setParameter("firstCategoryName", temp);
		           }
		           if(preOrderView.getPreOrderDate()!=null && preOrderView.getEndPreOrderDate()==null){
						query.setParameter("preOrderDate", preOrderView.getPreOrderDate());
					}
					if(preOrderView.getPreOrderDate()==null && preOrderView.getEndPreOrderDate()!=null){
						query.setParameter("endPreOrderDate", preOrderView.getEndPreOrderDate());
					}
					if(preOrderView.getPreOrderDate()!=null && preOrderView.getEndPreOrderDate()!=null){
						query.setParameter("preOrderDate", preOrderView.getPreOrderDate());
						query.setParameter("endPreOrderDate", preOrderView.getEndPreOrderDate());
					}
					if(preOrderView.getPreOrderEndDate()!=null && preOrderView.getEndPreOrderEndDate()==null){
						query.setParameter("preOrderEndDate", preOrderView.getPreOrderEndDate());
					}
					if(preOrderView.getPreOrderEndDate()==null && preOrderView.getEndPreOrderEndDate()!=null){
						query.setParameter("endPreOrderEndDate", preOrderView.getPreOrderEndDate());
					}
					if(preOrderView.getPreOrderEndDate()!=null && preOrderView.getEndPreOrderEndDate()!=null){
						query.setParameter("preOrderEndDate", preOrderView.getPreOrderEndDate());
						query.setParameter("endPreOrderEndDate", preOrderView.getEndPreOrderEndDate());
					}
				return query.list();
			}
           };
           Long totalCount = (Long)getHibernateTemplate().executeFind(callback_).iterator().next();
           preOrderView.setTotalCount(totalCount);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return preOrders;

	}
}
