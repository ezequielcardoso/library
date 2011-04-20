package com.huan.library.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.Punishment;
import com.huan.library.domain.model.book.Press;
import com.huan.library.domain.service.PunishmentService;
import com.huan.library.infrastructure.persistence.PunishmentDao;
import com.huan.library.web.view.PressView;
import com.huan.library.web.view.PunishmentView;
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
	
	public List<Punishment> findPunishments(PunishmentView punishmentView) throws Exception{
		List<Punishment> punishments = new ArrayList<Punishment>();
		try {
			punishments = punishmentDao.selectPunishments(punishmentView);
		} catch (Exception e) {
		  e.printStackTrace();
		  throw new Exception(e);
		}
		return punishments;
	}

}
