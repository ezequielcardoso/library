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
	
	public ReaderUnits getById(Long unitId) throws Exception {
		ReaderUnits readerUnits = new ReaderUnits();
		try {
			readerUnits = readerUnitsDao.getById(unitId);
		} catch (Exception e) {
		  e.printStackTrace();
		  throw new Exception(e);
		}
		return readerUnits;
	}

	public List<ReaderUnits> getChildrenByPid(Long pUnitId) throws Exception {
		 List<ReaderUnits> readerUnits = new ArrayList<ReaderUnits>();
		try {
			readerUnits = readerUnitsDao.selectChildrenByPid(pUnitId);
		} catch (Exception e) {
		  e.printStackTrace();
		  throw new Exception(e);
		}
		return readerUnits;
	}

	public void remove(ReaderUnits unit) throws Exception {
		try {
		   readerUnitsDao.delete(unit);	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public ReaderUnits save(ReaderUnits unit) throws Exception {
		ReaderUnits readerUnits = new ReaderUnits();
		try {
			readerUnits = readerUnitsDao.saveOrUpdate(unit);
		} catch (Exception e) {
		  e.printStackTrace();
		  throw new Exception(e);
		}
		return readerUnits;
	}

	/**
	 * @param readerUnitsDao the readerUnitsDao to set
	 */
	public void setReaderUnitsDao(ReaderUnitsDao readerUnitsDao) {
		this.readerUnitsDao = readerUnitsDao;
	}
	
}
