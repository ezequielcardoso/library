package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.domain.model.SysLog;
import com.huan.library.web.view.SysLogView;

public interface SysLogDao extends BaseDao<SysLog> {

	public List<SysLog> selectSysLogs(SysLogView sysLogView) ;
}
