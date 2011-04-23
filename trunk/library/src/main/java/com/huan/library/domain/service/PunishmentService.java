package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.domain.model.Punishment;
import com.huan.library.web.view.PunishmentView;


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
	 * @
	 */
	public Punishment addOrModifyPunlishment(Punishment punishment) ; 
	
	/**
	 * 查找所有的罚款
	 * @param punishmentView
	 * @return
	 * @
	 */
	public List<Punishment> findPunishments(PunishmentView punishmentView) ;
    /**
     * 导出Excel
     * @param rootDir
     * @param punishmentView
     * @return
     * @
     */
	public String exportExcel(String rootDir, PunishmentView punishmentView) ;

}
