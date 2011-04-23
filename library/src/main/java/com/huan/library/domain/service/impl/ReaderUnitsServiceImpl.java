package com.huan.library.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.reader.ReaderUnits;
import com.huan.library.domain.service.ReaderUnitsService;
import com.huan.library.infrastructure.persistence.ReaderUnitsDao;

/**
 * 
 * @author huan
 * @time 2011-4-10 下午07:38:49
 */
@Service("readerUnitsService")
public class ReaderUnitsServiceImpl implements ReaderUnitsService {

	@Autowired
	private ReaderUnitsDao readerUnitsDao;

	public ReaderUnits getById(Long unitId) {
		return readerUnitsDao.getById(unitId);
	}

	public List<ReaderUnits> getChildrenByPid(Long pUnitId) {
		return readerUnitsDao.selectChildrenByPid(pUnitId);
	}

	public void remove(ReaderUnits unit) {
		readerUnitsDao.delete(unit);
	}

	public ReaderUnits save(ReaderUnits unit) {
		return readerUnitsDao.saveOrUpdate(unit);
	}

	/**
	 * @param readerUnitsDao
	 *            the readerUnitsDao to set
	 */
	public void setReaderUnitsDao(ReaderUnitsDao readerUnitsDao) {
		this.readerUnitsDao = readerUnitsDao;
	}

}
