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
 * 
 * @author huan
 * @time 2011-3-16 下午11:11:00
 */
@Repository("punishmentDao")
public class PunishmentDaoImpl extends BaseDaoImpl<Punishment> implements
		PunishmentDao {

	public List<Punishment> selectPunishments(
			final PunishmentView punishmentView) {
		List<Punishment> punishments = new ArrayList<Punishment>();

		StringBuilder sql = new StringBuilder();
		StringBuilder sql_ = new StringBuilder();

		sql.append(" select new Punishment( p.id , p.punishMoney , p.eventsDesc, p.operatorDate ,"
				+ "p.operator , t_pc.itemId , t_pc.itemName , t_pr.id , t_pr.barCode ,"
				+ " t_pr.readerName, t_pru.unitId , t_pru.unitName , t_prt.id , t_prt.readerCateName ) ");
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

		StringBuilder whereSub = new StringBuilder();
		if(punishmentView.getReaderBarCode()!=null && !"".equals(punishmentView.getReaderBarCode())){
			whereSub.append(" and t_pr.barCode like (:readerBarCode) ");
		}
		if(punishmentView.getReaderName()!=null && !"".equals(punishmentView.getReaderName())){
			whereSub.append(" and t_pr.readerName like (:readerName) ");
		}
		if(punishmentView.getUnitName()!=null && !"".equals(punishmentView.getUnitName())){
			whereSub.append(" and t_pru.unitName like (:unitName) ");
		}
		if(punishmentView.getChargeName()!=null && !"".equals(punishmentView.getChargeName())){
			whereSub.append(" and t_pc.itemName like (:chargeName) ");
		}
		if(punishmentView.getOperator()!=null && !"".equals(punishmentView.getOperator())){
			whereSub.append(" and p.operator like (:operator) ");
		}
		if(punishmentView.getReaderCateName()!=null && !"".equals(punishmentView.getReaderCateName())){
			whereSub.append(" and t_prt.readerCateName like (:readerCateName) ");
		}
		if (punishmentView.getOperatorDate() != null
				&& punishmentView.getEndOperatorDate() == null) {
			whereSub.append(" and p.operatorDate = (:operatorDate) ");
		}
		if (punishmentView.getOperatorDate() == null
				&& punishmentView.getEndOperatorDate() != null) {
			whereSub.append(" and p.operatorDate = (:endOperatorDate) ");
		}
		if (punishmentView.getOperatorDate() != null
				&& punishmentView.getEndOperatorDate() != null) {
			whereSub.append(" and p.operatorDate between (:operatorDate) and (:endOperatorDate) ");
		}
		
		sql.append(whereSub);
		sql_.append(whereSub);
		
		final String sqlIn = sql.toString();
		HibernateCallback callback = new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(sqlIn);
				if (punishmentView != null && punishmentView.getIsPage()
						&& punishmentView.getStart() != null
						&& punishmentView.getLimit() != null) {
					query.setFirstResult(punishmentView.getStart());
					query.setMaxResults(punishmentView.getLimit());
				}
				String temp = "";
				if(punishmentView.getReaderBarCode()!=null && !"".equals(punishmentView.getReaderBarCode())){
					temp = "%" + punishmentView.getReaderBarCode().replace(" ", "%") + "%";
					query.setParameter("readerBarCode", temp);
				}
				if(punishmentView.getReaderName()!=null && !"".equals(punishmentView.getReaderName())){
					temp = "%" + punishmentView.getReaderName().replace(" ", "%") + "%";
					query.setParameter("readerName", temp);
				}
				if(punishmentView.getUnitName()!=null && !"".equals(punishmentView.getUnitName())){
					temp = "%" + punishmentView.getUnitName().replace(" ", "%") + "%";
					query.setParameter("unitName", temp);
				}
				if(punishmentView.getChargeName()!=null && !"".equals(punishmentView.getChargeName())){
					temp = "%" + punishmentView.getChargeName().replace(" ", "%") + "%";
					query.setParameter("chargeName", temp);
				}
				if(punishmentView.getOperator()!=null && !"".equals(punishmentView.getOperator())){
					temp = "%" + punishmentView.getOperator().replace(" ", "%") + "%";
					query.setParameter("operator", temp);
				}
				if(punishmentView.getReaderCateName()!=null && !"".equals(punishmentView.getReaderCateName())){
					temp = "%" + punishmentView.getReaderCateName().replace(" ", "%") + "%";
					query.setParameter("readerCateName", temp);
				}
				if (punishmentView.getOperatorDate() != null
						&& punishmentView.getEndOperatorDate() == null) {
					query.setParameter("operatorDate", punishmentView.getOperatorDate());
				}
				if (punishmentView.getOperatorDate() == null
						&& punishmentView.getEndOperatorDate() != null) {
					query.setParameter("endOperatorDate", punishmentView.getEndOperatorDate());
				}
				if (punishmentView.getOperatorDate() != null
						&& punishmentView.getEndOperatorDate() != null) {
					query.setParameter("operatorDate", punishmentView.getOperatorDate());
					query.setParameter("endOperatorDate", punishmentView.getEndOperatorDate());
				}
				return query.list();
			}
		};
		punishments = (List<Punishment>) getHibernateTemplate().executeFind(
				callback);

		final String sqlIn_ = sql_.toString();
		HibernateCallback callback_ = new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(sqlIn_);
				String temp = "";
				if(punishmentView.getReaderBarCode()!=null && !"".equals(punishmentView.getReaderBarCode())){
					temp = "%" + punishmentView.getReaderBarCode().replace(" ", "%") + "%";
					query.setParameter("readerBarCode", temp);
				}
				if(punishmentView.getReaderName()!=null && !"".equals(punishmentView.getReaderName())){
					temp = "%" + punishmentView.getReaderName().replace(" ", "%") + "%";
					query.setParameter("readerName", temp);
				}
				if(punishmentView.getUnitName()!=null && !"".equals(punishmentView.getUnitName())){
					temp = "%" + punishmentView.getUnitName().replace(" ", "%") + "%";
					query.setParameter("unitName", temp);
				}
				if(punishmentView.getChargeName()!=null && !"".equals(punishmentView.getChargeName())){
					temp = "%" + punishmentView.getChargeName().replace(" ", "%") + "%";
					query.setParameter("chargeName", temp);
				}
				if(punishmentView.getOperator()!=null && !"".equals(punishmentView.getOperator())){
					temp = "%" + punishmentView.getOperator().replace(" ", "%") + "%";
					query.setParameter("operator", temp);
				}
				if(punishmentView.getReaderCateName()!=null && !"".equals(punishmentView.getReaderCateName())){
					temp = "%" + punishmentView.getReaderCateName().replace(" ", "%") + "%";
					query.setParameter("readerCateName", temp);
				}
				if (punishmentView.getOperatorDate() != null
						&& punishmentView.getEndOperatorDate() == null) {
					query.setParameter("operatorDate", punishmentView.getOperatorDate());
				}
				if (punishmentView.getOperatorDate() == null
						&& punishmentView.getEndOperatorDate() != null) {
					query.setParameter("endOperatorDate", punishmentView.getEndOperatorDate());
				}
				if (punishmentView.getOperatorDate() != null
						&& punishmentView.getEndOperatorDate() != null) {
					query.setParameter("operatorDate", punishmentView.getOperatorDate());
					query.setParameter("endOperatorDate", punishmentView.getEndOperatorDate());
				}
				return query.list();
			}
		};
		Long totalCount = (Long) getHibernateTemplate().executeFind(callback_)
				.iterator().next();
		punishmentView.setTotalCount(totalCount);

		return punishments;
	}

}
