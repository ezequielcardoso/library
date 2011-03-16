package com.huan.library.infrastructure.persistence.impl;


import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.Punishment;
import com.huan.library.infrastructure.persistence.PunishmentDao;
/**
 * 罚款dao实现
 * @author huan
 * @time  2011-3-16 下午11:11:00
 */
@Repository("punishmentDao")
public class PunishmentDaoImpl extends BaseDaoImpl<Punishment> implements PunishmentDao {

	
}
