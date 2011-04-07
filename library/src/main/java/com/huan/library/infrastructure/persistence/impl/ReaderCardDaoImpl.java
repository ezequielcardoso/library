package com.huan.library.infrastructure.persistence.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.reader.ReaderCard;
import com.huan.library.infrastructure.persistence.ReaderCardDao;
import com.huan.library.web.view.ReaderCardView;
/**
 * 读者借阅证dao实现
 * @author huan
 * @time 2011-3-15 上午10:10:33
 */
@Repository("readerCardDao")
public class ReaderCardDaoImpl extends BaseDaoImpl<ReaderCard> implements ReaderCardDao {

	public List<ReaderCard> selectReaderCards(final ReaderCardView readerCardView)
			throws Exception {
		List<ReaderCard> readerCards = new ArrayList<ReaderCard>();
		try {
		    
			StringBuilder sql = new StringBuilder();   //查询总记录
		    StringBuilder sql_ = new StringBuilder();  //查询总的记录数
		    
		    sql.append(" select new ReaderCard(rc.id, rc.readerCardCode, rc.password, rc.barCode, rc.entyDate," +
		    		" rc.effectiveDate, rc.readerPic, rc.readerCardDesc, rc.cardState ," +
		    		"t_r.id, t_r.readerName, t_r.readerUnits.unitId, t_r.readerUnits.unitName)");
		    sql_.append(" select count(rc)");
		    
		    sql.append(" from ReaderCard rc");
		    sql_.append(" from ReaderCard rc");
		    
		    StringBuilder joinSub = new StringBuilder();
		    joinSub.append(" left join fetch rc.reader t_r");
		    
		    sql.append(joinSub);
	        sql_.append(joinSub);
	        
		    sql.append(" where 1=1");
		    sql_.append(" where 1=1");
		    
			StringBuilder whereSub = new StringBuilder();
			/**
			 * 拼接条件 如果某个字段的值不为空，则将作为查询条件
			 */
//			if(field!=null ){
//				whereSub.append(" and b.fieldName = : fieldValue ");
//			}
			//.......继续拼接........
			
			sql.append(whereSub);
            sql_.append(whereSub);
			//group by 子句 
			
			//order by 子句
 
			final String sqlIn = sql.toString(); 
			HibernateCallback callback = new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(sqlIn);
					if(readerCardView!=null && readerCardView.getIsPage()){
						query.setFirstResult(readerCardView.getStart());
						query.setMaxResults(readerCardView.getLimit());
					}
					return query.list();
				}
			};
			
			final String sqlIn_ = sql_.toString();
			HibernateCallback callback_ = new HibernateCallback(){
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(sqlIn_); 
					return query.list();
				}
			};
			Long totalCount = (Long)getHibernateTemplate().executeFind(callback_).iterator().next();
			readerCardView.setTotalCount(totalCount);
		  readerCards = (List<ReaderCard>)getHibernateTemplate().executeFind(callback);  
		} catch (Exception e) {
		  e.printStackTrace();
		  throw new Exception(e);
		}
		return readerCards;
	}


}
