package com.huan.library.domain.service;

import com.huan.library.domain.model.Punishment;


/**
 * 罚款显示层
 * @author huan
 * @time  2011-3-16 下午11:13:09
 */
public interface PunishmentService {
	/**
	 * 增加罚单
	 * @param punlishment
	 * @return
	 * @throws Exception
	 */
	public Punishment addOrModifyPunlishment(Punishment punishment) throws Exception; 

}
