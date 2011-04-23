package com.huan.library.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.SysLog;
import com.huan.library.domain.service.SysLogService;
import com.huan.library.infrastructure.persistence.SysLogDao;
import com.huan.library.web.view.SysLogView;
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
   
	@Autowired
	private SysLogDao sysLogDao;
	
	public List<SysLog> findSysLogs(SysLogView sysLogView)  {
		return sysLogDao.selectSysLogs(sysLogView);
	}

	public void setSysLogDao(SysLogDao sysLogDao) {
		this.sysLogDao = sysLogDao;
	}
   
}
