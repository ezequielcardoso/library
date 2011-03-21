package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.domain.model.reader.ReaderUnits;

/**
 * 读者单位dao
 * @author huan
 * @time 2011-3-15 上午10:01:42
 */
public interface ReaderUnitsDao extends BaseDao<ReaderUnits>{
	
	/**
	 * 批量增加班级
	 * @param readerUnitses
	 * @throws Exception
	 */
	public void insertReaderUnitsesBatch(List<ReaderUnits> readerUnitses) throws Exception;
}
