package com.huan.library.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.Punishment;
import com.huan.library.domain.service.PunishmentService;
import com.huan.library.infrastructure.persistence.PunishmentDao;
/**
 * 罚款service实现
 * @author huan
 * @time  2011-3-16 下午11:16:23
 */
@Service("punishmentService")
public class PunishmentServiceImpl implements PunishmentService {

	@Autowired
	public PunishmentDao punishmentDao;
	
	public void setPunishmentDao(PunishmentDao punishmentDao) {
		this.punishmentDao = punishmentDao;
	}

	public Punishment addOrModifyPunlishment(Punishment punishment)
			throws Exception {
		Punishment punishmentCopy = new Punishment();
		try {
			punishmentCopy = punishmentDao.saveOrUpdate(punishment);
		} catch (Exception e) {
		  e.printStackTrace();
		  return null;
		}
		return punishmentCopy;
	}

}
