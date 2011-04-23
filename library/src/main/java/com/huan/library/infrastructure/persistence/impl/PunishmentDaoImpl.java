package com.huan.library.infrastructure.persistence.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.Punishment;
import com.huan.library.infrastructure.persistence.PunishmentDao;
import com.huan.library.web.view.PunishmentView;
/**
 * 罚款dao实现
 * @author huan
 * @time  2011-3-16 下午11:11:00
 */
@Repository("punishmentDao")
public class PunishmentDaoImpl extends BaseDaoImpl<Punishment> implements PunishmentDao {

	public List<Punishment> selectPunishments(final PunishmentView punishmentView)
	throws Exception {
		List<Punishment> punishments = new ArrayList<Punishment>(); 
		try {
			StringBuilder sql = new StringBuilder();
			StringBuilder sql_ = new StringBuilder();
			
			sql.append(" select new Punishment( p.id , p.punishMoney , p.eventsDesc, p.operatorDate ," +
					"p.operator , t_pc.itemId , t_pc.itemName , t_pr.id , t_pr.barCode ," +
					" t_pr.readerName, t_pru.unitId , t_pru.unitName , t_prt.id , t_prt.readerCateName ) ");
			sql_.append(" select count(p) ");
			
			sql.append(" from Punishment p ");
			sql_.append(" from Punishment p ");
			
			StringBuilder joinSub = new StringBuilder();
			joinSub.append(" left join p.charge t_pc ");
			joinSub.append(" left join p.reader t_pr ");
			joinSub.append(" left join p.reader.readerUnits t_pru ");
			joinSub.append(" left join p.reader.readerType t_prt ");
			
			sql.append(joinSub);
			sql_.append(joinSub);
			
			sql.append(" where 1=1 ");
			sql_.append(" where 1=1 ");
			
			
			/**
			 * 
			 */
			StringBuilder whereSub = new StringBuilder();
			
			final String sqlIn = sql.toString();
			HibernateCallback callback = new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(sqlIn);
					if(punishmentView!=null && punishmentView.getIsPage()&&punishmentView.getStart()!=null
							&&punishmentView.getLimit()!=null){
						query.setFirstResult(punishmentView.getStart());
						query.setMaxResults(punishmentView.getLimit());
					}
					return query.list();
				}
			};
			punishments = (List<Punishment>)getHibernateTemplate().executeFind(callback);
			
			final String sqlIn_ = sql_.toString();
			HibernateCallback callback_ = new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(sqlIn_); 
					return query.list();
				}
			};
			Long totalCount = (Long) getHibernateTemplate().executeFind(
					callback_).iterator().next();
			punishmentView.setTotalCount(totalCount);
		} catch (Exception e) {
		  e.printStackTrace();
		  throw new Exception(e);
		}
		return punishments;
	}
	
}
