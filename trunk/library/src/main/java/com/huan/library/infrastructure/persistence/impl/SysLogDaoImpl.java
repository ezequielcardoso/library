package com.huan.library.infrastructure.persistence.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.SysLog;
import com.huan.library.infrastructure.persistence.SysLogDao;
import com.huan.library.web.view.SysLogView;

@Repository("sysLogDao")
public class SysLogDaoImpl extends BaseDaoImpl<SysLog> implements SysLogDao {

	public List<SysLog> selectSysLogs(final SysLogView sysLogView) {
		List<SysLog> sysLogs = new ArrayList<SysLog>();

		StringBuilder sql = new StringBuilder();
		StringBuilder sql_ = new StringBuilder();

		sql.append(" from  SysLog sl where 1=1 ");
		sql_.append(" select count(sl) from SysLog sl where 1=1 ");
		// 查询字段
		StringBuilder whereSub = new StringBuilder();
		if (sysLogView.getOperateType() != null
				&& !"".equals(sysLogView.getOperateType())) {
			whereSub.append(" and sl.operateType like (:operateType) ");
		}
		if (sysLogView.getFuncName() != null
				&& !"".equals(sysLogView.getFuncName())) {
			whereSub.append(" and sl.funcName like (:funcName) ");
		}
		if (sysLogView.getOperatorName() != null
				&& !"".equals(sysLogView.getOperatorName())) {
			whereSub.append(" and sl.operatorName like (:operatorName) ");
		}
		if (sysLogView.getOperator() != null
				&& !"".equals(sysLogView.getOperator())) {
			whereSub.append(" and sl.operator like (:operator) ");
		}
		if (sysLogView.getOperateDate() != null
				&& sysLogView.getEndOperateDate() == null) {
			whereSub.append(" and sl.operateDate =(:operateDate) ");
		}
		if (sysLogView.getOperateDate() == null
				&& sysLogView.getEndOperateDate() != null) {
			whereSub.append(" and sl.operateDate =(:endOperateDate) ");
		}
		if (sysLogView.getOperateDate() != null
				&& sysLogView.getEndOperateDate() != null) {
			whereSub.append(" and sl.operateDate between (:operateDate) and (:endOperateDate) ");
		}

		sql.append(whereSub);
		sql_.append(whereSub);

		final String sqlIn = sql.toString();
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(sqlIn);
				if (sysLogView != null && sysLogView.getIsPage()
						&& sysLogView.getStart() != null
						&& sysLogView.getLimit() != null) {
					query.setFirstResult(sysLogView.getStart());
					query.setMaxResults(sysLogView.getLimit());
				}
				String temp = "";
				if (sysLogView.getOperateType() != null
						&& !"".equals(sysLogView.getOperateType())) {
					temp = "%" + sysLogView.getOperateType().replace(" ", "%")
							+ "%";
					query.setParameter("operateType", temp);
				}
				if (sysLogView.getFuncName() != null
						&& !"".equals(sysLogView.getFuncName())) {
					temp = "%" + sysLogView.getFuncName().replace(" ", "%")
							+ "%";
					query.setParameter("funcName", temp);
				}
				if (sysLogView.getOperatorName() != null
						&& !"".equals(sysLogView.getOperatorName())) {
					temp = "%" + sysLogView.getOperatorName().replace(" ", "%")
							+ "%";
					query.setParameter("operatorName", temp);
				}
				if (sysLogView.getOperator() != null
						&& !"".equals(sysLogView.getOperator())) {
					temp = "%" + sysLogView.getOperator().replace(" ", "%")
							+ "%";
					query.setParameter("operator", temp);
				}
				if (sysLogView.getOperateDate() != null
						&& sysLogView.getEndOperateDate() == null) {
					query.setParameter("operateDate",
							sysLogView.getOperateDate());
				}
				if (sysLogView.getOperateDate() == null
						&& sysLogView.getEndOperateDate() != null) {
					query.setParameter("endOperateDate",
							sysLogView.getEndOperateDate());
				}
				if (sysLogView.getOperateDate() != null
						&& sysLogView.getEndOperateDate() != null) {
					query.setParameter("operateDate",
							sysLogView.getOperateDate());
					query.setParameter("endOperateDate",
							sysLogView.getEndOperateDate());
				}
				return query.list();
			}
		};
		sysLogs = (List<SysLog>) getHibernateTemplate().executeFind(callback);

		final String sqlIn_ = sql_.toString();
		HibernateCallback callback_ = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(sqlIn_);
				String temp = "";
				if (sysLogView.getOperateType() != null
						&& !"".equals(sysLogView.getOperateType())) {
					temp = "%" + sysLogView.getOperateType().replace(" ", "%")
							+ "%";
					query.setParameter("operateType", temp);
				}
				if (sysLogView.getFuncName() != null
						&& !"".equals(sysLogView.getFuncName())) {
					temp = "%" + sysLogView.getFuncName().replace(" ", "%")
							+ "%";
					query.setParameter("funcName", temp);
				}
				if (sysLogView.getOperatorName() != null
						&& !"".equals(sysLogView.getOperatorName())) {
					temp = "%" + sysLogView.getOperatorName().replace(" ", "%")
							+ "%";
					query.setParameter("operatorName", temp);
				}
				if (sysLogView.getOperator() != null
						&& !"".equals(sysLogView.getOperator())) {
					temp = "%" + sysLogView.getOperator().replace(" ", "%")
							+ "%";
					query.setParameter("operator", temp);
				}
				if (sysLogView.getOperateDate() != null
						&& sysLogView.getEndOperateDate() == null) {
					query.setParameter("operateDate",
							sysLogView.getOperateDate());
				}
				if (sysLogView.getOperateDate() == null
						&& sysLogView.getEndOperateDate() != null) {
					query.setParameter("endOperateDate",
							sysLogView.getEndOperateDate());
				}
				if (sysLogView.getOperateDate() != null
						&& sysLogView.getEndOperateDate() != null) {
					query.setParameter("operateDate",
							sysLogView.getOperateDate());
					query.setParameter("endOperateDate",
							sysLogView.getEndOperateDate());
				}
				return query.list();
			}
		};
		Long totalCount = (Long) getHibernateTemplate().executeFind(callback_)
				.iterator().next();
		sysLogView.setTotalCount(totalCount);
		return sysLogs;
	}
}
