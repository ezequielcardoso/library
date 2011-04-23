package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.domain.model.Punishment;
import com.huan.library.web.view.PunishmentView;

/**
 * 罚款dao
 * @author Administrator
 * @time  2011-3-16 下午11:08:54
 */
public interface PunishmentDao extends BaseDao<Punishment>{
  
	public List<Punishment> selectPunishments(PunishmentView punishmentView) ;
	
}
