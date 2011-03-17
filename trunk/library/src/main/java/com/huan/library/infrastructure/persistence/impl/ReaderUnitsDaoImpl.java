package com.huan.library.infrastructure.persistence.impl;


import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.reader.ReaderUnits;
import com.huan.library.infrastructure.persistence.ReaderUnitsDao;
/**
 * 读者单位dao实现
 * @author huan
 * @time  2011-3-17 上午10:52:07
 */
@Repository("readerUnitsDao")
public class ReaderUnitsDaoImpl extends BaseDaoImpl<ReaderUnits> implements
		ReaderUnitsDao {

	
}
