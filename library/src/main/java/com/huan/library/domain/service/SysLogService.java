package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.domain.model.SysLog;
import com.huan.library.web.view.SysLogView;

/**
 * 系统日志
 * @author Administrator
 *
 */
public interface SysLogService {

	public List<SysLog> findSysLogs(SysLogView sysLogView) ;
	
	public void save(SysLog sysLog);
}
